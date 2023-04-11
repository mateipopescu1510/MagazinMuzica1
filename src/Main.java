import Model.Distributor;
import Model.Instrument;
import Model.Shop;
import Utils.InstrumentType;
import Utils.ProductStatus;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Distributor fender = new Distributor("Fender", "Calea Victoriei 164", "customerrelations@fender.com");
		Shop shop = Shop.getInstance();
		System.out.println(shop);
		List<Distributor>distributors = new ArrayList<>(shop.distributors);
		System.out.println(distributors.get(0));
		System.out.println(fender);
		System.out.println(distributors.get(0)==fender);
		System.out.println(fender.equals(distributors.get(0)));
	}
}