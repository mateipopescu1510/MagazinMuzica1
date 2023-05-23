package Service;

import Model.*;
import Utils.AmplifierType;
import Utils.InstrumentType;
import Utils.OrderStatus;
import Utils.OrdersComparator;

import java.util.*;

public class Client implements ClientService{
	private static int clientCounter = 10000;
	private String name, address, email;
	private int age, specialDiscountPercent;
	private final int clientId;
	private List<Order> orders;
	
	public Client(String name, String address, String email, int age, int specialDiscountPercent) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.specialDiscountPercent = specialDiscountPercent;
		this.clientId = Client.clientCounter;
		Client.clientCounter++;
		this.orders = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSpecialDiscountPercent() {
		return specialDiscountPercent;
	}
	
	public void setSpecialDiscountPercent(int specialDiscountPercent) {
		this.specialDiscountPercent = specialDiscountPercent;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public static int getClientCounter() {
		return clientCounter;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public List<Integer> getOrderIds(){
		List<Integer> orderIds = new ArrayList<>();
		for (Order order : orders){
			orderIds.add(order.getOrderId());
		}
		return orderIds;
	}
	public void createOrder(Shop shop){
		Scanner input = new Scanner(System.in);
		System.out.println("How many items in the order?");
		int itemNumber = input.nextInt();
		List<Product> products = new ArrayList<>();
		
		for(int i = 0; i < itemNumber; i++){
			System.out.println("What kind of product to add to the order? 'Instrument', 'Amplifier' or 'Album':");
			
			boolean valid = false;
			String option = input.nextLine();
			
			while(!valid){
				option = input.nextLine();
				if(option.equals("Instrument") || option.equals("Amplifier") || option.equals("Album")){
					valid = true;
				}
				else{
					System.out.println("Invalid choice, try again;");
				}
			}
			if (option.equals("Instrument")){
				System.out.println("What type of instrument?");
				for(InstrumentType instrumentType : InstrumentType.values()){
					System.out.print(instrumentType + " ");
				}
				System.out.println();
				String type = input.nextLine();
				System.out.println("What variant?");
				String variant = input.nextLine();
				
				Instrument instrument = shop.getInstrument(variant, type);
				if(instrument == null){
					System.out.println("No such instrument is in stock!");
				}
				else{
					products.add(instrument);
					shop.removeProduct(instrument.getProductId());
					System.out.println("Item has been succesfully added to the order!");
				}
			}
			
			if(option.equals("Amplifier")){
				System.out.println("Weight of the Amp?");
				int weight = input.nextInt();
				System.out.println("Wattage of the Amp?");
				int wattage = input.nextInt();
				System.out.println("What type of Amp?");
				for(AmplifierType amplifierType : AmplifierType.values()){
					System.out.print(amplifierType + " ");
				}
				System.out.println();
				String type = input.nextLine();
				Amplifier amplifier = shop.getAmplifier(weight, wattage, type);
				if(amplifier == null){
					System.out.println("No such amplifier is in stock!");
				}
				else{
					products.add(amplifier);
					shop.removeProduct(amplifier.getProductId());
					System.out.println("Item has been succesfully added to the order!");
				}
			}
			
			if(option.equals("Album")){
				System.out.println("By what artist?");
				String artist = input.nextLine();
				System.out.println("What is the title of the album?");
				String title = input.nextLine();
				Album album = shop.getAlbum(artist, title);
				if(album == null){
					System.out.println("No such album is in stock!");
				}
				else{
					products.add(album);
					shop.removeProduct(album.getProductId());
					System.out.println("Item has been succesfully added to the order!");
				}
			}
		}
		
		boolean valid = false;
		System.out.println("What courier should deliver the products?");
		String courierName = "";
		Courier courier = null;
		while(!valid){
			courierName = input.nextLine();
			courier = shop.getCourier(courierName);
			if(courier != null){
				valid = true;
			}
			else{
				System.out.println("This company does not work with us, try again!");
			}
		}
		Order order = new Order(courier, products, OrderStatus.IN_PROGRESS);
		orders.add(order);
		System.out.println("Order with ID " + order.getOrderId() + " has been succesfully created!");
	}
	
	public void cancelOrder(Shop shop, int orderId){
		boolean found = false;
		Order order = null;
		for(Order o : orders){
			if(o.getOrderId() == orderId){
				order = o;
				found = true;
				break;
			}
		}
		if(!found){
			System.out.println("No order with ID " + orderId + " was found!");
			return;
		}
		if(order.getStatus().equals(OrderStatus.CANCELED)){
			System.out.println("Order with ID " + orderId + " is already canceled!");
			return;
		}
		
		order.setStatus(OrderStatus.CANCELED);
		for(Product product : order.getProducts()){
			if(product instanceof Instrument instrument){
				shop.addInstrument(instrument);
			}
			if(product instanceof Album album){
				shop.addAlbum(album);
			}
			if(product instanceof Amplifier amplifier)
				shop.addAmplifier(amplifier);
		}
		
		System.out.println("Order with ID " + orderId + " has been successfully canceled!");
		
	}
	
	public void confirmOrder(Shop shop, int orderId){
		boolean found = false;
		Order order = null;
		for(Order o : orders){
			if(o.getOrderId() == orderId){
				order = o;
				found = true;
				break;
			}
		}
		if(!found){
			System.out.println("No order with ID " + orderId + " was found!");
			return;
		}
		if(order.getStatus().equals(OrderStatus.CANCELED)){
			System.out.println("Cannot confirm an already canceled order as delivered!");
			return;
		}
		order.setStatus(OrderStatus.DELIVERED);
		System.out.println("Order with ID " + orderId + " has been successfully delivered!");
	}
	
	
	
	public float calculateTotalCost() {
		float totalCost = 0;
		for(Order order : orders){
			if(order.getStatus() != OrderStatus.CANCELED)
				totalCost += order.calculateTotalCost();
		}
		return totalCost * (100 - specialDiscountPercent)/100;
	}
	
	public List<Order> ordersByPrice() {
		orders.sort(new OrdersComparator());
		return orders;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Client client)) return false;
		return getAge() == client.getAge() && getName().equals(client.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAge());
	}
	
	@Override
	public String toString() {
		return "Client{" +
				"name='" + name + '\'' +
				", age=" + age +
				", specialDiscountPercent=" + specialDiscountPercent +
				"}\n";
	}
}
