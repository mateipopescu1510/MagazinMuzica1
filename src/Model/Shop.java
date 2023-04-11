package Model;

import java.util.HashSet;
import java.util.Set;

public class Shop {
	public final String urlAddress = "mateisguitarshop.com";
	private Set<Product> stock;
	public Set<Distributor> distributors;
	private Set<Employee> employees;
	private final String storageAddress = "Bd Dorobanti 129";
	
	private static Shop instance = null;
	private Shop(){
		distributors = new HashSet<>();
		distributors.add(new Distributor("Fender", "Calea Victoriei 164", "customerrelations@fender.com"));
		distributors.add(new Distributor("Ibanez", "Piata Presei 27", "customerrelations@ibanez.com"));
		distributors.add(new Distributor("Yamaha", "Stefan cel Mare 40", "customerrelations@yamaha.com"));
		distributors.add(new Distributor("PMCmusic", "Bd Daciei 23", "customerrelations@pmcmusic.com"));
	}
	public synchronized static Shop getInstance(){
		if(instance == null)
			instance = new Shop();
		return instance;
	}
}
