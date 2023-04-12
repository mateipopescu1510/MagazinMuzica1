package Model;

import Utils.AmplifierType;
import Utils.InstrumentType;
import Utils.JobTitle;
import Utils.ProductStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shop {
	public final String urlAddress = "mateisguitarshop.com";
	public List<Product> stock;
	public Set<Distributor> distributors;
	public Set<Employee> employees;
	private final String storageAddress = "Bd Dorobanti 129";
	
	private static Shop instance = null;
	private Shop(){
		distributors = new HashSet<>();
		distributors.add(new Distributor("Fender", "Calea Victoriei 164", "customerrelations@fender.com"));
		distributors.add(new Distributor("Ibanez", "Piata Presei 27", "customerrelations@ibanez.com"));
		distributors.add(new Distributor("Yamaha", "Stefan cel Mare 40", "customerrelations@yamaha.com"));
		distributors.add(new Distributor("PMCmusic", "Bd Daciei 23", "customerrelations@pmcmusic.com"));
		
		employees = new HashSet<>();
		employees.add(new Employee("Popescu Matei", "popescumatei@gmail.com", 35, 10000, JobTitle.MANAGER));
		employees.add(new Employee("Julian Groensmit", "jgroensmit@gmail.com", 34, 9000, JobTitle.DESIGN));
		employees.add(new Employee("Stoian Andrei", "standrei@gmail.com",37, 9500, JobTitle.BACKEND));
		employees.add(new Employee("Garotescu Mihai", "mihaigrt@gmai.com", 31, 8000, JobTitle.CUSTOMER_SUPPORT));
		employees.add(new Employee("Apostol Mihnea", "apmihea@gmail.com", 34, 7500, JobTitle.MAINTENANCE));
		
		stock = new ArrayList<>();
		stock.add(new Instrument(4000, 12, 5, getDistributor("Fender"), ProductStatus.IN_STOCK,"wood","Stratocaster",
				InstrumentType.ELECTRIC_GUITAR));
		stock.add(new Instrument(4000, 12, 5, getDistributor("Fender"), ProductStatus.IN_STOCK,"wood","Stratocaster",
				InstrumentType.ELECTRIC_GUITAR));
		stock.add(new Album(50, 1, 5, getDistributor("PMCmusic"), ProductStatus.IN_STOCK, "AC/DC", "Back in Black",
				1981,
				49));
		stock.add(new Album(60,1,4,getDistributor("PMCmusic"),ProductStatus.OUT_OF_STOCK, "Metallica", "Hardwired",
				2016,
				65));
		stock.add(new Amplifier(1800, 24, 10, getDistributor("Ibanez"), ProductStatus.LIMITED, 10, 50,
				AmplifierType.SOLID_STATE));
	}
	public void addInstrument(int howMany, int price, int warrantyMonths, int discountPercent,
	                          Distributor distributor, ProductStatus status, String material, String variant, InstrumentType instrumentType){
		for(int i = 0; i < howMany; i++){
			stock.add(new Instrument(price, warrantyMonths, discountPercent, distributor, status, material, variant,
					instrumentType));
		}
	}
	
	public void modifyProduct(int productId, int price, int warrantyMonths , int discountPercent,
	                          ProductStatus status){
		boolean found = false;
		for(Product product: stock){
			if (product.getProductId() == productId){
				found = true;
				product.setPrice(price);
				product.setWarrantyMonths(warrantyMonths);
				product.setDiscountPercent(discountPercent);
				product.setStatus(status);
				System.out.println("The product with ID " + productId +" has been updated:\n" + product);
				break;
			}
		}
		if(!found){
			System.out.println("No product with ID " + productId + " has been found!");
		}
	}
	
	public void addAmplifier(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                         ProductStatus status, int weight, int wattage, AmplifierType amplifierType0){
		for(int i = 0; i < howMany; i++){
			stock.add(new Amplifier(price, warrantyMonths, discountPercent, distributor, status, weight, wattage,
					amplifierType0));
		}
	}
	
	public void addAlbum(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                     ProductStatus status, String artist, String title, int releaseYear, int lengthMinutes){
		for(int i = 0; i < howMany; i++){
			stock.add(new Album(price, warrantyMonths, discountPercent, distributor, status, artist, title,
					releaseYear, lengthMinutes));
		}
	}
	
	public void addEmployee(String name, String email, int age, int salary, JobTitle jobTitle){
		employees.add(new Employee(name, email, age, salary, jobTitle));
	}
	
	public Employee getEmployee(String name, String email, int age){
		ArrayList<Employee> emplyeesList = new ArrayList<>(employees);
		Employee employee = new Employee(name, email, age, 0, null);
		for (Employee emp : emplyeesList) {
			if (emp.equals(employee))
				return emp;
		}
		return null;
	}
	
	public void addDistributor(String name, String address, String email){
		Distributor distributor = new Distributor(name, address, email);
		if(getDistributor(name) != null){
			System.out.println("Distributor " + name + " already works with our shop!");
		}
		else{
			distributors.add(distributor);
			System.out.println("Distributor " + name + " has been added!");
		}
	}
	
	public Distributor getDistributor(String name){
		ArrayList<Distributor> distributorsList = new ArrayList<>(distributors);
		Distributor distributor = new Distributor(name, null, null);
		for (Distributor distr : distributorsList){
			if(distr.equals(distributor))
				return distr;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Shop{" +
				"urlAddress='" + urlAddress + '\'' +
				", distributors=" + distributors +
				", storageAddress='" + storageAddress + '\'' +
				'}';
	}
	
	public synchronized static Shop getInstance(){
		if(instance == null)
			instance = new Shop();
		return instance;
	}
}
