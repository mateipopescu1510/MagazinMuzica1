package Model;

import Utils.JobTitle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shop {
	public final String urlAddress = "mateisguitarshop.com";
	private List<Product> stock;
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
		
	}
	
	public void addEmployee(String name, String email, int age, int salary, JobTitle jobTitle){
		employees.add(new Employee(name, email, age, salary, jobTitle));
	}
	
	public void addDistributor(String name, String address, String email){
		distributors.add(new Distributor(name, address, email));
	}
	
	@Override
	public String toString() {
		return "Shop{" +
				"urlAddress='" + urlAddress + '\'' +
				", stock=" + stock +
				", distributors=" + distributors +
				", employees=" + employees +
				", storageAddress='" + storageAddress + '\'' +
				'}';
	}
	
	public synchronized static Shop getInstance(){
		if(instance == null)
			instance = new Shop();
		return instance;
	}
}
