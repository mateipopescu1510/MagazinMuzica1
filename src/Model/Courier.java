package Model;

import Utils.TransportType;

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
	public String toString() {
		return "Courier{" +
				"name='" + name + '\'' +
				", transportType=" + transportType +
				", commissionPercent=" + commissionPercent +
				'}';
	}
}
