package Model;

import Utils.JobTitle;

public class Employee {
	private String name, email;
	private int age, salary;
	private JobTitle jobTitle;
	
	public Employee(String name, String email, int age, int salary, JobTitle jobTitle) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.jobTitle = jobTitle;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", jobTitle=" + jobTitle +
				'}';
	}
}
