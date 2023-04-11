package Model;

import Utils.ProductStatus;

import java.util.Objects;

public class Album extends Product{
	private String artist, title;
	private int releaseYear, lengthMinutes;
	
	public Album(int price, int warrantyMonths, int discountPercent, Distributor distributor, ProductStatus status, String artist, String title, int releaseYear, int lengthMinutes) {
		super(price, warrantyMonths, discountPercent, distributor, status);
		this.artist = artist;
		this.title = title;
		this.releaseYear = releaseYear;
		this.lengthMinutes = lengthMinutes;
	}
	
	public Album(Album product){
		super(product.price, product.warrantyMonths, product.discountPercent, product.distributor, product.status);
		this.artist = product.artist;
		this.title = product.title;
		this.releaseYear = product.releaseYear;
		this.lengthMinutes = product.lengthMinutes;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getLengthMinutes() {
		return lengthMinutes;
	}
	
	public void setLengthMinutes(int lengthMinutes) {
		this.lengthMinutes = lengthMinutes;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Album album)) return false;
		return getArtist().equals(album.getArtist()) && getTitle().equals(album.getTitle());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getArtist(), getTitle());
	}
	
	@Override
	public String toString() {
		return "Album{" +
				"artist='" + artist + '\'' +
				", title='" + title + '\'' +
				", price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", distributor=" + distributor.getName() +
				'}';
	}
}
