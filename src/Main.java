import Model.Distributor;
import Model.Instrument;
import Utils.InstrumentType;

public class Main {
	static Distributor fender = new Distributor("Fender", "address","fender@gmail.com");
	public static void main(String[] args) {
		Instrument f1 = new Instrument(4000,12,10,fender,"wood","Strat", InstrumentType.ELECTRIC_GUITAR);
		System.out.println(f1);
	}
}