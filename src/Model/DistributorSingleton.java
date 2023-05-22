package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistributorSingleton {
	private static DistributorSingleton instance = null;
	private Set<Distributor> distributors;
	public static DistributorSingleton getInstance(){
		if(instance == null)
			instance = new DistributorSingleton();
		return instance;
	}
	
	private DistributorSingleton(){
		distributors = new HashSet<Distributor>();
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
	
	public Set<Distributor> getDistributors() {
		return distributors;
	}
	
	public void setDistributors(HashSet<Distributor> distributors) {
		this.distributors = distributors;
	}
	
	public void addDistributor(Distributor distributor){
		this.distributors.add(distributor);
	}
	
	public void readFromCSV(){
		List<String[]> columns = getFromCSV("src/Data/distributors.csv");
		for(String[] line: columns){
			Distributor distributor = new Distributor(line[0], line[1], line[2]);
			distributors.add(distributor);
		}
	}
	
	public void writeInCSV(){
		try{
			FileWriter fw = new FileWriter("src/Data/distributors.csv");
			for(Distributor distributor: distributors){
				fw.write(distributor.getName() + ", " +
						distributor.getAddress() + ", " +
						distributor.getEmail()+ "\n");
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
	}
	
}
