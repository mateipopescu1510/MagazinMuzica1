package Model;

import java.util.List;

public class Client {
	private static int clientCounter = 10000;
	private String name, address, email;
	private int age, specialDiscountPercent;
	private final int clientId;
	private List<Order> orders;
	
	public Client(String name, String address, String email, int age, int specialDiscountPercent, int clientId, List<Order> orders) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.specialDiscountPercent = specialDiscountPercent;
		this.clientId = Client.clientCounter;
		Client.clientCounter++;
		this.orders = orders;
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
	
	@Override
	public String toString() {
		return "Client{" +
				"name='" + name + '\'' +
				", age=" + age +
				", specialDiscountPercent=" + specialDiscountPercent +
				'}';
	}
}
