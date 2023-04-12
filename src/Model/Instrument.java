package Model;

import Utils.InstrumentType;
import Utils.ProductStatus;

import java.util.Objects;

public class Instrument extends Product{
	private String material, variant;
	private InstrumentType instrumentType;
	
	public Instrument(int price, int warrantyMonths, int discountPercent, Distributor distributor, ProductStatus status, String material, String variant, InstrumentType instrumentType) {
		super(price, warrantyMonths, discountPercent, distributor, status);
		this.material = material;
		this.variant = variant;
		this.instrumentType = instrumentType;
	}
	
	public Instrument(Instrument product){
		super(product.price, product.warrantyMonths, product.discountPercent, product.distributor, product.status);
		this.material = product.material;
		this.variant = product.variant;
		this.instrumentType = product.instrumentType;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Instrument that)) return false;
		return getVariant().equals(that.getVariant()) && getInstrumentType() == that.getInstrumentType();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getVariant(), getInstrumentType());
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
				"}\n";
	}
}
