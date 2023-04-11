package Model;
import Utils.OrderStatus;

import java.util.List;

public class Order {
	private static int orderCounter = 1000;
	private final int orderId;
	
	private OrderStatus status;
	private Courier courier;
	private List<Product> products;
	
	public Order(int orderId, Courier courier, List<Product> products, OrderStatus status) {
		this.orderId = Order.orderCounter;
		Order.orderCounter++;
		this.courier = courier;
		this.products = products;
		this.status = status;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public static int getOrderCounter() {
		return orderCounter;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public Courier getCourier() {
		return courier;
	}
	
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void addProduct(Product product){
		this.products.add(product);
	}
	public void removeProduct(Product product){
		this.products.remove(product);
	}
}
