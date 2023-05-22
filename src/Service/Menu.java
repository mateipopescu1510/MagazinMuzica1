package Service;

import Model.Distributor;
import Model.Instrument;
import Model.Order;
import Model.Product;
import Utils.AmplifierType;
import Utils.Audit;
import Utils.InstrumentType;
import Utils.ProductStatus;

import java.util.*;

public final class Menu {
	private static Menu instance = null;
	private static Shop shop;
	private static Set<Client> clients;
	
	private static Map<Integer, String> events;
	private static Audit audit;
	
	private Menu(){
		shop = Shop.getInstance();
		clients = new HashSet<>();
		audit = new Audit();
		events =  new HashMap<Integer, String>(){{
			put(1, "addClient");
			put(2, "createOrder");
			put(3, "cancelOrder");
			put(4, "addProduct");
			put(5, "calculateClientCost");
			put(6, "showOrders");
			put(7, "showShopStock");
			put(8, "viewProductsOfOrder");
			put(9, "addDistributor");
			put(10, "confirmOrderDelivered");
			put(11, "showAllClients");
		}};
		
		clients.add(new Client("Mircea Bogdan", "adresa 1", "mirceabgd@gmail.com", 23, 1 ));
		clients.add(new Client("Stefan Andrei", "adresa 2", "stfnandr@gmail.com", 22, 5));
		clients.add(new Client("Ionescu Alex", "adresa 3", "ionescualex@gmail.com", 20, 7));
	}
	
	private static void addClient(){
		Scanner inputClient = new Scanner(System.in);
		System.out.println("What is the name of the new client?");
		String name = inputClient.nextLine();
		System.out.println("What is the client's address?");
		String address = inputClient.nextLine();
		System.out.println("What is the client's email?");
		String email = inputClient.nextLine();
		System.out.println("How old is the client?");
		int age = inputClient.nextInt();
		System.out.println("Does the client have a special discount? (0 - 100%)");
		int discoutPercent = inputClient.nextInt();
		clients.add(new Client(name, address, email, age, discoutPercent));
		System.out.println("Client " + name + " has been successfully added to the list!");
	}
	
	private static void showClients(){
		ArrayList<Client> clientsList = new ArrayList<>(clients);
		for(Client client: clientsList){
			System.out.println(client);
		}
	}
	private static Client getClient(){
		ArrayList<Client> clientsList = new ArrayList<>(clients);
		Scanner inputClient = new Scanner(System.in);
		System.out.println("What is the name of the client?");
		String name = inputClient.nextLine();
		System.out.println("How old is the client?");
		int age = inputClient.nextInt();
		
		Client client = new Client(name, "", "", age, 0);
		for(Client cl : clientsList){
			if (cl.equals(client))
				return cl;
		}
		return null;
	}
	
	private void addProduct(){
		Scanner inputProduct = new Scanner(System.in);
		System.out.println("What kind of product to add to the stock? 'Instrument', 'Amplifier' or 'Album':");
		
		boolean valid = false;
		String option = "";
		
		while(!valid){
			option = inputProduct.nextLine();
			if(option.equals("Instrument") || option.equals("Amplifier") || option.equals("Album")){
				valid = true;
			}
			else{
				System.out.println("Invalid choice, try again;");
			}
		}
		
		System.out.println("How many products like this?");
		int howMany = inputProduct.nextInt();
		
		System.out.println("What price?");
		int price = inputProduct.nextInt();
		
		System.out.println("How many months of warranty?");
		int warrantyMonths = inputProduct.nextInt();
		
		System.out.println("Does it have a discout? (0 - 100%)");
		int discountPercent = inputProduct.nextInt();
		
		System.out.println("What distributor delivers this product?");
		String distr = inputProduct.nextLine();
		Distributor distributor = shop.getDistributor(distr) != null ? shop.getDistributor(distr) :
				shop.getDistributor("NONE");
		
		
		ProductStatus status = ProductStatus.IN_STOCK;
		
		if(option.equals("Instrument")){
			System.out.println("What material is the instrument made of?");
			String material = inputProduct.nextLine();
			
			System.out.println("What type of instrument?");
			for(InstrumentType instrumentType : InstrumentType.values()){
				System.out.print(instrumentType + " ");
			}
			System.out.println();
			
			InstrumentType instrumentType = null;
			while (instrumentType == null){
				String instr = inputProduct.nextLine();
				for (InstrumentType type : InstrumentType.values()){
					if (type.name().equals(instr)) {
						instrumentType = type;
						break;
					}
				}
				System.out.println("Wrong type, try again");
			}
			
			System.out.println("What variant?");
			String variant = inputProduct.nextLine();
			
			shop.addInstrument(howMany, price, warrantyMonths, discountPercent,
					distributor, status, material, variant, instrumentType);
			System.out.println(howMany + " instruments have been successfully added to the stock!");
			return;
		}
		
		if(option.equals("Amplifier")){
			System.out.println("What is the weight of the Amp?");
			int weight = inputProduct.nextInt();
			
			System.out.println("What is the wattage of the Amp?");
			int wattage = inputProduct.nextInt();
			
			System.out.println("What type of Amp?");
			for(AmplifierType amplifierType : AmplifierType.values()){
				System.out.print(amplifierType + " ");
			}
			System.out.println();
			
			AmplifierType amplifierType = null;
			while (amplifierType == null){
				String amp = inputProduct.nextLine();
				for (AmplifierType type : AmplifierType.values()){
					if (type.name().equals(amp)) {
						amplifierType = type;
						break;
					}
				}
				System.out.println("Wrong type, try again");
			}
			
			shop.addAmplifier(howMany, price, warrantyMonths, discountPercent, distributor,
					status, weight, wattage, amplifierType);
			System.out.println(howMany + " amplifiers have been successfully added to the stock!");
			return;
		}
		
		if(option.equals("Album")){
			System.out.println("What is the name of the artist?");
			String artist = inputProduct.nextLine();
			
			System.out.println("What is the title of the album?");
			String title = inputProduct.nextLine();
			
			System.out.println("In what year was the album released?");
			int releaseYear = inputProduct.nextInt();
			
			System.out.println("What is the duration of the album in minutes?");
			int lengthMinutes = inputProduct.nextInt();
			
			shop.addAlbum(howMany, price, warrantyMonths, discountPercent, distributor, status,
					artist, title, releaseYear, lengthMinutes);
			System.out.println(howMany + " albums have been successfully added to the stock!");
		}
	}
	
	private void addDistributor(){
		Scanner inputDistributor = new Scanner(System.in);
		System.out.println("What is the name of the distributor?");
		String name = inputDistributor.nextLine();
		
		System.out.println("What is the address of the distributor?");
		String address = inputDistributor.nextLine();
		
		System.out.println("What email does the distributor have?");
		String email = inputDistributor.nextLine();
		
		shop.addDistributor(name, address, email);
	}
	
	private synchronized static void showOptions(){
		System.out.println("Choose an action:\n");
		System.out.println("1. Add a new client");
		System.out.println("2. Create an order for an existing client");
		System.out.println("3. Cancel an order for an existing client");
		System.out.println("4. Add a new product to the shop's stock");
		System.out.println("5. Calculate a client's cost of all their orders");
		System.out.println("6. Show a client's orders sorted by price");
		System.out.println("7. Show the current stock of the shop");
		System.out.println("8. View what products a client ordered");
		System.out.println("9. Add a new distributor");
		System.out.println("10. Confirm a client's order as delivered");
		System.out.println("11. Show all clients");
		System.out.println("0. Exit the application");
	}
	public synchronized static Menu getInstance(){
		if(instance == null)
			instance = new Menu();
		return instance;
	}
	public void showMenu(){
		Scanner input = new Scanner(System.in);
		int option = -1;
		while(option != 0){
			showOptions();
			
			option = input.nextInt();
			switch(option){
				case 1: {
					addClient();
					break;
				}
				case 2: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					client.createOrder(shop);
					break;
				}
				case 3: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					System.out.println("The client's orders have the following IDs:");
					System.out.println(client.getOrderIds());
					int orderId = input.nextInt();
					client.cancelOrder(shop, orderId);
					break;
				}
				case 4: {
					addProduct();
				}
				case 5: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					System.out.println("The client has spent a total of " + client.calculateTotalCost());
					break;
				}
				case 6: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					for (Order order : client.ordersByPrice()){
						System.out.println(order);
					}
					break;
				}
				case 7: {
					System.out.println(shop.getStock());
					break;
				}
				case 8: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					if(client.getOrders().size() > 0){
						for(Order order : client.getOrders()){
							for(Product product : order.getProducts())
								System.out.println(product);
						}
					}
					break;
				}
				case 9: {
					addDistributor();
					break;
				}
				case 10: {
					Client client = getClient();
					if(client == null){
						System.out.println("No client found!");
						break;
					}
					System.out.println("The client's orders have the following IDs:");
					System.out.println(client.getOrderIds());
					int orderId = input.nextInt();
					client.confirmOrder(shop, orderId);
					break;
				}
				case 11: {
					showClients();
				}
				case 0: {
					System.out.println("Exit.");
					break;
				}
				default:
					System.out.println("Invalid option, try again!");
					break;
					
			}
			try{
				if(option != 0)
					audit.log(events.get(option));
			}
			catch(Exception exception){
				System.out.println(exception.getMessage());
			}
		}
	}

}
