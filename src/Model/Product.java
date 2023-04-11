package Model;

public abstract class Product {
	private static int productCounter = 100;
	private int price, warrantyMonths, discountPercent, productId;
	private Distributor distributor;
	
	public Product(int price, int warrantyMonths, int discountPercent, Distributor distributor) {
		this.price = price;
		this.warrantyMonths = warrantyMonths;
		this.discountPercent = discountPercent;
		this.productId = Product.productCounter;
		Product.productCounter++;
		this.distributor = distributor;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getWarrantyMonths() {
		return warrantyMonths;
	}
	
	public void setWarrantyMonths(int warrantyMonths) {
		this.warrantyMonths = warrantyMonths;
	}
	
	public int getDiscountPercent() {
		return discountPercent;
	}
	
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public Distributor getDistributor() {
		return distributor;
	}
	
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	
	public int getProductId() {
		return productId;
	}
}
