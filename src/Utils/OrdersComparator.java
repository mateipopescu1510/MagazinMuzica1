package Utils;


import Model.Order;

import java.util.Comparator;

public class OrdersComparator implements Comparator<Order> {
	
	@Override
	public int compare(Order o1, Order o2) {
		return Float.compare(o1.calculateTotalCost(), o2.calculateTotalCost());
	}
}
