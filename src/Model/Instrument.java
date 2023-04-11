package Model;

import Utils.InstrumentType;
import Utils.ProductStatus;

public class Instrument extends Product{
	private String material, variant;
	private InstrumentType instrumentType;
	
	public Instrument(int price, int warrantyMonths, int discountPercent, Distributor distributor, ProductStatus status, String material, String variant, InstrumentType instrumentType) {
		super(price, warrantyMonths, discountPercent, distributor, status);
		this.material = material;
		this.variant = variant;
		this.instrumentType = instrumentType;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getVariant() {
		return variant;
	}
	
	public void setVariant(String variant) {
		this.variant = variant;
	}
	
	public InstrumentType getInstrumentType() {
		return instrumentType;
	}
	
	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}
	
	@Override
	public String toString() {
		return "Instrument{" +
				"instrumentType=" + instrumentType +
				", variant='" + variant + '\'' +
				", price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", distributor=" + distributor +
				'}';
	}
}
