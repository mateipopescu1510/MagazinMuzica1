package Model;

import Utils.JobTitle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeSingleton {
	private static EmployeeSingleton instance = null;
	private Set<Employee> employees;
	public static EmployeeSingleton getInstance(){
		if(instance == null)
			instance = new EmployeeSingleton();
		return instance;
	}
	
	private EmployeeSingleton(){
		employees = new HashSet<Employee>();
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
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee){
		this.employees.add(employee);
	}
	
	public void readFromCSV(){
		List<String[]> columns = getFromCSV("src/Data/employees.csv");
		for(String[] line: columns){
			int age = Integer.parseInt(line[2]);
			int salary = Integer.parseInt(line[3]);
			JobTitle title = JobTitle.valueOf(line[4]);
			Employee employee = new Employee(line[0], line[1], age, salary, title);
			employees.add(employee);
		}
	}
	
	public void writeInCSV(){
		try{
			FileWriter fw = new FileWriter("src/Data/employees.csv");
			for(Employee employee: employees){
				fw.write(employee.getName() + ", " +
						employee.getEmail() + ", " +
						employee.getAge() + ", " +
						employee.getSalary() + ", " +
						employee.getJobTitle() + "\n");
			}
			fw.close();
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
	}
}
