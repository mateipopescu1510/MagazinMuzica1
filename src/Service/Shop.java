package Service;

import Model.*;
import Utils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shop implements ShopService{
	public final String urlAddress = "mateisguitarshop.com";
	private List<Product> stock;
	private DistributorSingleton distributors = DistributorSingleton.getInstance();
	private EmployeeSingleton employees = EmployeeSingleton.getInstance();
	
	private CourierSingleton couriers = CourierSingleton.getInstance();
	private final String storageAddress = "Bd Dorobanti 129";
	
	private static Shop instance = null;
	private Shop(){
		couriers.readFromCSV();
		distributors.readFromCSV();
		employees.readFromCSV();
		stock = new ArrayList<Product>();
		readFromCSV();
		
//		stock = new ArrayList<>();
//		stock.add(new Instrument(4000, 12, 5, getDistributor("Fender"), ProductStatus.IN_STOCK,"wood","Stratocaster",
//				InstrumentType.ELECTRIC_GUITAR));
//		stock.add(new Instrument(4000, 12, 5, getDistributor("Fender"), ProductStatus.IN_STOCK,"wood","Stratocaster",
//				InstrumentType.ELECTRIC_GUITAR));
//		stock.add(new Album(50, 1, 5, getDistributor("PMCmusic"), ProductStatus.IN_STOCK, "AC/DC", "Back in Black",
//				1981,
//				49));
//		stock.add(new Album(60,1,4,getDistributor("PMCmusic"),ProductStatus.OUT_OF_STOCK, "Metallica", "Hardwired",
//				2016,
//				65));
//		stock.add(new Amplifier(1800, 24, 10, getDistributor("Ibanez"), ProductStatus.LIMITED, 10, 50,
//				AmplifierType.SOLID_STATE));
	}
	
	private void readFromCSV(){
		List<String[]>columns = getFromCSV("src/Data/stock.csv");
		for(String[] line: columns){
			int price = Integer.parseInt(line[1]);
			int warrantyMonths = Integer.parseInt(line[2]);
			int discountPercent = Integer.parseInt(line[3]);
			Distributor distributor = getDistributor(line[4]);
			ProductStatus productStatus = ProductStatus.valueOf(line[5]);
			if(line[0].equals("1")){
				//Album
				String artist = line[6];
				String title = line[7];
				int releaseYear = Integer.parseInt(line[8]);
				int lengthMinutes = Integer.parseInt(line[9]);
				stock.add(new Album(price, warrantyMonths, discountPercent, distributor, productStatus, artist, title
						, releaseYear, lengthMinutes));
			}
			if(line[0].equals("2")){
				//Amplifier
				int weight = Integer.parseInt(line[6]);
				int wattage = Integer.parseInt(line[7]);
				AmplifierType type = AmplifierType.valueOf(line[8]);
				stock.add(new Amplifier(price, warrantyMonths, discountPercent, distributor, productStatus, weight,
						wattage, type));
			}
			if(line[0].equals("3")){
				//Instrument
				String material = line[6];
				String variant = line[7];
				InstrumentType type = InstrumentType.valueOf(line[8]);
				stock.add(new Instrument(price, warrantyMonths, discountPercent, distributor, productStatus, material
						, variant, type));
			}
		}
	}
	
	private void writeInCSV(){
		try{
			FileWriter fw = new FileWriter("src/Data/stock.csv");
			for(Product product: stock){
				if(product instanceof Album album){
					fw.write("1, " +
							album.getPrice() + ", " +
							album.getWarrantyMonths() + ", " +
							album.getDiscountPercent() + ", " +
							album.getDistributor().getName() + ", " +
							album.getStatus().name() + ", " +
							album.getArtist() + ", " +
							album.getTitle() + ", " +
							album.getReleaseYear() + ", " +
							album.getLengthMinutes() + "\n");
				}
				if(product instanceof Amplifier amplifier){
					fw.write("2, " +
							amplifier.getPrice() + ", " +
							amplifier.getWarrantyMonths() + ", " +
							amplifier.getDiscountPercent() + ", " +
							amplifier.getDistributor().getName() + ", " +
							amplifier.getStatus().name() + ", " +
							amplifier.getWeight() + ", " +
							amplifier.getWattage() + ", " +
							amplifier.getAmplifierType().name() + "\n");
				}
				if(product instanceof Instrument instrument){
					fw.write("3, " +
							instrument.getPrice() + ", " +
							instrument.getWarrantyMonths() + ", " +
							instrument.getDiscountPercent() + ", " +
							instrument.getDistributor().getName() + ", " +
							instrument.getStatus().name() + ", " +
							instrument.getMaterial() + ", " +
							instrument.getVariant() + ", " +
							instrument.getInstrumentType().name() + "\n");
				}
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
	}
	
	private static List<String[]> getFromCSV(String path){
		List <String[]> columns = new ArrayList<String[]>();
		try(var input = new BufferedReader(new FileReader(path))){
			String line;
			while((line = input.readLine()) != null) {
				String[] info = line.replaceAll(" ", "").split(",");
				columns.add(info);
			}
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
		return columns;
	}
	
	public List<Product> getStock() {
		return stock;
	}
	
	public void updateStockCSV(){
		this.writeInCSV();
	}
	
	public void setStock(List<Product> stock) {
		this.stock = stock;
	}
	
	public Set<Distributor> getDistributors() {
		return distributors.getDistributors();
	}
	
	public void setDistributors(Set<Distributor> distributors) {
		this.distributors.setDistributors((HashSet<Distributor>) distributors);
	}
	
	public Set<Employee> getEmployees() {
		return employees.getEmployees();
	}
	
	public Set<Courier> getCouriers(){
		return couriers.getCouriers();
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees.setEmployees(employees);
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
		employees.addEmployee(new Employee(name, email, age, salary, jobTitle));
	}
	
	public Employee getEmployee(String name, String email, int age){
		ArrayList<Employee> emplyeesList = new ArrayList<>(employees.getEmployees());
		Employee employee = new Employee(name, email, age, 0, null);
		for (Employee emp : emplyeesList) {
			if (emp.equals(employee))
				return emp;
		}
		return null;
	}
	
	public void removeEmployee(String name, String email, int age){
		ArrayList<Employee> employeesList = new ArrayList<>(employees.getEmployees());
		Employee employee = new Employee(name, email, age, 0, null);
		boolean found = false;
		for(Employee emp : employeesList){
			if(emp.equals(employee)){
				found = true;
				employeesList.remove(emp);
				employees.setEmployees(new HashSet<>(employeesList));
				System.out.println("Employee with the name " + name + " has been removed.");
				break;
			}
		}
		if(!found){
			System.out.println("No employee with the name " + name + " was found!");
		}
	}
	
	public void updateEmployeesCSV(){
		employees.writeInCSV();
	}
	
	public void addDistributor(String name, String address, String email){
		Distributor distributor = new Distributor(name, address, email);
		if(getDistributor(name) != null){
			System.out.println("Distributor " + name + " already works with our shop!");
		}
		else{
			distributors.addDistributor(distributor);
			System.out.println("Distributor " + name + " has been added!");
		}
	}
	
	public void updateDistributorsCSV(){
		distributors.writeInCSV();
	}
	
	public void addCourier(String name, TransportType transportType, int commissionPercent){
		Courier courier = new Courier(name, transportType, commissionPercent);
		if(getCourier(name) != null){
			System.out.println(name + " already works with our shop!");
		}
		else{
			couriers.addCourier(courier);
			System.out.println(name + " has been added!");
		}
	}
	
	
	public Distributor getDistributor(String name){
		ArrayList<Distributor> distributorsList = new ArrayList<>(distributors.getDistributors());
		Distributor distributor = new Distributor(name, null, null);
		for (Distributor distr : distributorsList){
			if(distr.equals(distributor))
				return distr;
		}
		return null;
	}
	
	public Courier getCourier(String name){
		ArrayList<Courier> couriersList = new ArrayList<>(couriers.getCouriers());
		Courier courier = new Courier(name, null, 0);
		for (Courier c : couriersList){
			if (c.equals(courier))
				return c;
		}
		return null;
	}
	
	public void updateCourierCSV(){
		couriers.writeInCSV();
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
