package Model;

import java.util.Objects;

public class Distributor {
	private String name, address, email;
	
	public Distributor(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Distributor that)) return false;
		return getName().equals(that.getName()) && getEmail().equals(that.getEmail());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getEmail());
	}
	
	@Override
	public String toString() {
		return "Distributor{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				"}\n";
	}
}
