package Service;

import Model.Album;
import Model.Amplifier;
import Model.Distributor;
import Model.Instrument;
import Utils.AmplifierType;
import Utils.InstrumentType;
import Utils.JobTitle;
import Utils.ProductStatus;

public interface ShopService {
	public void addInstrument(int howMany, int price, int warrantyMonths, int discountPercent,
	                          Distributor distributor, ProductStatus status, String material, String variant,
	                          InstrumentType instrumentType);
	public void addInstrument(Instrument instrument);
	public void modifyProduct(int productId, int price, int warrantyMonths , int discountPercent,
	                          ProductStatus status);
	public void removeProduct(int productId);
	public void addAmplifier(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                         ProductStatus status, int weight, int wattage, AmplifierType amplifierType0);
	public void addAmplifier(Amplifier amplifier);
	public void addAlbum(int howMany, int price, int warrantyMonths, int discountPercent, Distributor distributor,
	                     ProductStatus status, String artist, String title, int releaseYear, int lengthMinutes);
	public void addAlbum(Album album);
	
	public void addEmployee(String name, String email, int age, int salary, JobTitle jobTitle);
	public void removeEmployee(String name, String email, int age);
	
	public void addDistributor(String name, String address, String email);
	public Distributor getDistributor(String name);
	
	public Instrument getInstrument(String variant, String instrumentType);
	public Amplifier getAmplifier(int weight, int wattage, String amplifierType);
	
	public Album getAlbum(String artist, String title);

}
