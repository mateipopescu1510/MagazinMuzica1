package Service;

import Model.*;
import Utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shop implements ShopService{
	public final String urlAddress = "mateisguitarshop.com";
	private List<Product> stock;
	private Set<Distributor> distributors;
	private Set<Employee> employees;
	
	private Set<Courier>couriers;
	private final String storageAddress = "Bd Dorobanti 129";
	
	private static Shop instance = null;
	private Shop(){
		couriers = new HashSet<>();
		couriers.add(new Courier("FedEx", TransportType.INTERNATIONAL, 5));
		couriers.add(new Courier("Cargus", TransportType.SAME_DAY, 5));
		
		
		distributors = new HashSet<>();
		distributors.add(new Distributor("Fender", "Calea Victoriei 164", "customerrelations@fender.com"));
		distributors.add(new Distributor("Ibanez", "Piata Presei 27", "customerrelations@ibanez.com"));
		distributors.add(new Distributor("Yamaha", "Stefan cel Mare 40", "customerrelations@yamaha.com"));
		distributors.add(new Distributor("PMCmusic", "Bd Daciei 23", "customerrelations@pmcmusic.com"));
		distributors.add(new Distributor("NONE", null, null));
		
		
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
	
	public List<Product> getStock() {
		return stock;
	}
	
	public void setStock(List<Product> stock) {
		this.stock = stock;
	}
	
	public Set<Distributor> getDistributors() {
		return distributors;
	}
	
	public void setDistributors(Set<Distributor> distributors) {
		this.distributors = distributors;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public String getStorageAddress() {
		return storageAddress;
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
	
	
	
	public void removeProduct(int productId){
		boolean found = false;
		for(Product product : stock){
			if(product.getProductId() == productId) {
				found = true;
				stock.remove(product);
				break;
			}
		}
		if(!found)
			System.out.println("No product with ID " + productId + " has been found!");
	}
	
	public void addAmplifier(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                         ProductStatus status, int weight, int wattage, AmplifierType amplifierType0){
		for(int i = 0; i < howMany; i++){
			stock.add(new Amplifier(price, warrantyMonths, discountPercent, distributor, status, weight, wattage,
					amplifierType0));
		}
	}
	
	public void addAmplifier(Amplifier amplifier){
		stock.add(amplifier);
	}
	
	public void addInstrument(int howMany, int price, int warrantyMonths, int discountPercent,
	                          Distributor distributor, ProductStatus status, String material, String variant, InstrumentType instrumentType){
		for(int i = 0; i < howMany; i++){
			stock.add(new Instrument(price, warrantyMonths, discountPercent, distributor, status, material, variant,
					instrumentType));
		}
	}
	
	public void addInstrument(Instrument instrument){
		stock.add(instrument);
	}
	
	public void addAlbum(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                     ProductStatus status, String artist, String title, int releaseYear, int lengthMinutes){
		for(int i = 0; i < howMany; i++){
			stock.add(new Album(price, warrantyMonths, discountPercent, distributor, status, artist, title,
					releaseYear, lengthMinutes));
		}
	}
	
	public void addAlbum(Album album){
		stock.add(album);
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
	
	public void removeEmployee(String name, String email, int age){
		ArrayList<Employee> emplyeesList = new ArrayList<>(employees);
		Employee employee = new Employee(name, email, age, 0, null);
		boolean found = false;
		for(Employee emp : emplyeesList){
			if(emp.equals(employee)){
				found = true;
				employees.remove(employee);
				System.out.println("Employee with the name " + name + " has been removed.");
				break;
			}
		}
		if(!found){
			System.out.println("No employee with the name " + name + " was found!");
		}
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
	
	public void addCourier(String name, TransportType transportType, int commissionPercent){
		Courier courier = new Courier(name, transportType, commissionPercent);
		if(getCourier(name) != null){
			System.out.println(name + " already works with our shop!");
		}
		else{
			couriers.add(courier);
			System.out.println(name + " has been added!");
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
	
	public Courier getCourier(String name){
		ArrayList<Courier> couriersList = new ArrayList<>(couriers);
		Courier courier = new Courier(name, null, 0);
		for (Courier c : couriersList){
			if (c.equals(courier))
				return c;
		}
		return null;
	}
	
	public Instrument getInstrument(String variant, String instrumentType){
		InstrumentType instrumentType1 = null;
		for (InstrumentType type : InstrumentType.values()){
			if (type.name().equals(instrumentType))
				instrumentType1 = type;
		}
		if (instrumentType1 == null)
			return null;
		Instrument instrument = new Instrument(0,0,0,
				getDistributor("NONE"), ProductStatus.LIMITED, "", variant, instrumentType1);
		for (Product product : stock){
			if(product instanceof Instrument instrument1){
				if(instrument1.equals(instrument) && instrument1.getStatus() != ProductStatus.OUT_OF_STOCK)
					return instrument1;
			}
		}
		return null;
	}
	
	public Amplifier getAmplifier(int weight, int wattage, String amplifierType){
		AmplifierType amplifierType1 = null;
		for (AmplifierType type : AmplifierType.values()){
			if (type.name().equals(amplifierType)){
				amplifierType1 = type;
			}
		}
		if (amplifierType1 == null)
			return null;
		Amplifier amplifier = new Amplifier(0, 0, 0, getDistributor("NONE"), ProductStatus.LIMITED,
				weight, wattage, amplifierType1);
		for (Product product : stock){
			if(product instanceof Amplifier amplifier1){
				if(amplifier1.equals(amplifier) && amplifier1.getStatus() != ProductStatus.OUT_OF_STOCK)
					return amplifier1;
			}
		}
		return null;
	}
	
	public Album getAlbum(String artist, String title){
		Album album = new Album(0, 0, 0, getDistributor("NONE"), ProductStatus.LIMITED,
				artist, title, 0, 0);
		for (Product product : stock){
			if(product instanceof Album album1){
				if(album1.equals(album) && album1.getStatus() != ProductStatus.OUT_OF_STOCK)
					return album1;
			}
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
