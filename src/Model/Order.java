package Model;
import Utils.OrderStatus;

import java.util.List;
import java.util.Objects;

public class Order {
	private static int orderCounter = 1000;
	private final int orderId;
	
	private OrderStatus status;
	private Courier courier;
	private List<Product> products;
	
	public Order(Courier courier, List<Product> products, OrderStatus status) {
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
	
	public float calculateTotalCost(){
		float totalCost = 0;
		for (Product product : products){
			totalCost += (float) product.getPrice() * (100 - product.getDiscountPercent())/100;
		}
		return totalCost;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Order order)) return false;
		return getOrderId() == order.getOrderId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getOrderId());
	}
	
	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", status=" + status +
				", cost=" + calculateTotalCost() +
				"}\n";
	}
}
