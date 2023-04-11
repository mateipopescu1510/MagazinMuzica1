package Model;

import Utils.AmplifierType;

public class Amplifier extends Product {
	private int weight, wattage;
	private AmplifierType amplifierType;
	
	public Amplifier(int price, int warrantyMonths, int discountPercent, Distributor distributor, int weight, int wattage, AmplifierType amplifierType) {
		super(price, warrantyMonths, discountPercent, distributor);
		this.weight = weight;
		this.wattage = wattage;
		this.amplifierType = amplifierType;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWattage() {
		return wattage;
	}
	
	public void setWattage(int wattage) {
		this.wattage = wattage;
	}
	
	public AmplifierType getAmplifierType() {
		return amplifierType;
	}
	
	public void setAmplifierType(AmplifierType amplifierType) {
		this.amplifierType = amplifierType;
	}
}
