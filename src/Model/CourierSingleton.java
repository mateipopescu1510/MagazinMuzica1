package Model;

import Utils.TransportType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourierSingleton {
	private static CourierSingleton instance = null;
	private Set<Courier> couriers;
	public static CourierSingleton getInstance(){
		if(instance == null)
			instance = new CourierSingleton();
		return instance;
	}
	private CourierSingleton(){
		couriers = new HashSet<Courier>();
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
	
	public Set<Courier> getCouriers() {
		return couriers;
	}
	
	public void setCouriers(Set<Courier> couriers) {
		this.couriers = couriers;
	}
	
	public void addCourier(Courier courier){
		this.couriers.add(courier);
	}
	
	public void readFromCSV(){
		List<String[]> columns = getFromCSV("src/Data/couriers.csv");
		for(String[] line: columns){
			TransportType transportType = TransportType.valueOf(line[1]);
			int commission = Integer.parseInt(line[2]);
			Courier courier = new Courier(line[0], transportType, commission);
			couriers.add(courier);
		}
	}
	
	public void writeInCSV(){
		try{
			FileWriter fw = new FileWriter("src/Data/couriers.csv");
			for(Courier courier: couriers){
				fw.write(courier.getName() + ", " +
						courier.getTransportType() + ", " +
						courier.getCommissionPercent() + "\n");
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
	}
}
