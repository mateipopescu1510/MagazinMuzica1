package Service;

import Model.Order;

import java.util.List;

public interface ClientService {
	public void createOrder(Shop shop);
	public void cancelOrder(Shop shop, int orderId);
	
	public void confirmOrder(Shop shop, int orderId);
	
	public float calculateTotalCost();
	
	public List<Order> ordersByPrice();
}
