package Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientSingleton {
	private static ClientSingleton instance = null;
	private List<Client> clients;
	public static ClientSingleton getInstance(){
		if(instance == null)
			instance = new ClientSingleton();
		return instance;
	}
	
	private ClientSingleton(){
		clients = new ArrayList<Client>();
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
	
	public List<Client> getClients(){
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client client){
		this.clients.add(client);
	}
	
	public void readFromCSV(){
		List<String[]> columns = getFromCSV("src/Data/clients.csv");
		for(String[] line: columns){
			int age = Integer.parseInt(line[3]);
			int discount = Integer.parseInt(line[4]);
			Client client = new Client(line[0], line[1], line[2], age, discount);
			clients.add(client);
		}
	}
	
	public void writeInCSV(){
		try{
			FileWriter fw = new FileWriter("src/Data/clients.csv");
			for(Client client: clients){
				fw.write(client.getName() +", "+ client.getAddress() +","+
						client.getEmail()+", "+ client.getAge()+", "+
						client.getSpecialDiscountPercent() + "\n");
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
	}
}
