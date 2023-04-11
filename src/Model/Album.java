package Model;

public class Album extends Product{
	private String artist, title;
	private int releaseYear, lengthMinutes;
	
	public Album(int price, int warrantyMonths, int discountPercent, Distributor distributor, String artist, String title, int releaseYear, int lengthMinutes) {
		super(price, warrantyMonths, discountPercent, distributor);
		this.artist = artist;
		this.title = title;
		this.releaseYear = releaseYear;
		this.lengthMinutes = lengthMinutes;
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
	public String toString() {
		return "Album{" +
				"artist='" + artist + '\'' +
				", title='" + title + '\'' +
				", releaseYear=" + releaseYear +
				", lengthMinutes=" + lengthMinutes +
				", price=" + price +
				", warrantyMonths=" + warrantyMonths +
				", discountPercent=" + discountPercent +
				", productId=" + productId +
				", distributor=" + distributor +
				'}';
	}
}
