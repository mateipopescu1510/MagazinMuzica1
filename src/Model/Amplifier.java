package Model;

import Utils.AmplifierType;
import Utils.ProductStatus;

import java.util.Objects;

public class Amplifier extends Product {
	private int weight, wattage;
	private AmplifierType amplifierType;
	
	public Amplifier(int price, int warrantyMonths, int discountPercent, Distributor distributor, ProductStatus status, int weight, int wattage, AmplifierType amplifierType) {
		super(price, warrantyMonths, discountPercent, distributor, status);
		this.weight = weight;
		this.wattage = wattage;
		this.amplifierType = amplifierType;
	}
	public Amplifier(Amplifier product){
		super(product.price, product.warrantyMonths, product.discountPercent, product.distributor, product.status);
		this.weight = product.weight;
		this.wattage = product.wattage;
		this.amplifierType = product.amplifierType;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Amplifier amplifier)) return false;
		return getWeight() == amplifier.getWeight() && getWattage() == amplifier.getWattage() && getAmplifierType() == amplifier.getAmplifierType();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getWeight(), getWattage(), getAmplifierType());
	}
	
	@Override
	public String toString() {
		return "Amplifier{" +
				", wattage=" + wattage +
				", amplifierType=" + amplifierType +
				", price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", distributor=" + distributor.getName() +
				'}';
	}
}

