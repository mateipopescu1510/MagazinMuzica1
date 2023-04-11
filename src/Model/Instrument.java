package Model;

import Utils.InstrumentType;

public class Instrument extends Product{
	private String material, variant;
	private InstrumentType instrumentType;
	
	public Instrument(int price, int warrantyMonths, int discountPercent, Distributor distributor, String material, String variant, InstrumentType instrumentType) {
		super(price, warrantyMonths, discountPercent, distributor);
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
				"material='" + material + '\'' +
				", variant='" + variant + '\'' +
				", instrumentType=" + instrumentType +
				", price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", productId=" + productId +
				", distributor=" + distributor +
				'}';
	}
}
