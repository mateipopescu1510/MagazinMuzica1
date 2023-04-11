package Model;

import Utils.TransportType;

public class Courier {
	private String name;
	private TransportType transportType;
	
	public Courier(String name, TransportType transportType) {
		this.name = name;
		this.transportType = transportType;
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
}
