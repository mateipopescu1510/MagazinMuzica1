package Model;

import Utils.TransportType;

import java.util.Objects;

public class Courier {
	private String name;
	private TransportType transportType;
	
	private int commissionPercent;
	
	public Courier(String name, TransportType transportType, int commissionPercent) {
		this.name = name;
		this.transportType = transportType;
		this.commissionPercent = commissionPercent;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public TransportType getTransportType() {
		return transportType;
	}
	
	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}
	
	public int getCommissionPercent() {
		return commissionPercent;
	}
	
	public void setCommissionPercent(int commissionPercent) {
		this.commissionPercent = commissionPercent;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Courier courier)) return false;
		return getName().equals(courier.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}
	
	@Override
	public String toString() {
		return "Courier{" +
				"name='" + name + '\'' +
				", transportType=" + transportType +
				", commissionPercent=" + commissionPercent +
				'}';
	}
}
