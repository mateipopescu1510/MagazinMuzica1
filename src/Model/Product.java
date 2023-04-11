package Model;

import Utils.ProductStatus;

public abstract class Product {
	protected static int productCounter = 100;
	protected int price;
	protected int warrantyMonths;
	protected int discountPercent;
	protected int productId;
	protected Distributor distributor;
	
	protected ProductStatus status;
	
	public Product(int price, int warrantyMonths, int discountPercent, Distributor distributor, ProductStatus status) {
		this.price = price;
		this.warrantyMonths = warrantyMonths;
		this.discountPercent = discountPercent;
		this.productId = Product.productCounter;
		Product.productCounter++;
		this.distributor = distributor;
		this.status = status;
	}
	
	public Product(Product product){
		this.price = product.price;
		this.warrantyMonths = product.warrantyMonths;
		this.discountPercent = product.discountPercent;
		this.productId=Product.productCounter;
		Product.productCounter++;
		this.distributor = product.distributor;
		this.status = product.status;
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
	
	@Override
	public String toString() {
		return "Product{" +
				"price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", distributor=" + distributor.getName() +
				'}';
	}
}
