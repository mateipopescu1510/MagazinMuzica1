import Model.Distributor;
import Model.Instrument;
import Model.Shop;
import Utils.InstrumentType;
import Utils.ProductStatus;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		Distributor fender = new Distributor("Fender", "Calea Victoriei 164", "customerrelations@fender.com");
		Shop shop = Shop.getInstance();
//		System.out.println(shop);
//		List<Distributor>distributors = new ArrayList<>(shop.distributors);
//		System.out.println(distributors.get(0));
//		System.out.println(fender);
//		System.out.println(distributors.get(0)==fender);
//		System.out.println(fender.equals(distributors.get(0)));
		
//		Instrument g = new Instrument(4000, 12, 5, fender,ProductStatus.IN_STOCK,"wood","Stratocaster",
//				InstrumentType.ELECTRIC_GUITAR);
//		System.out.println(g.getProductId());
//		Instrument g1 = new Instrument(g);
//		System.out.println(g1.getProductId());
//		System.out.println(g == g1);
//		System.out.println(g.equals(g1));

//		System.out.println(shop.employees);
//		System.out.println(shop.getEmployee("Popescu", "popescumatei@gmail.com", 35));
//		System.out.println(shop.stock);
		System.out.println(shop.stock.get(0).equals(shop.stock.get(2)));
	
	}
}