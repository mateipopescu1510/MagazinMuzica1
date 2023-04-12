import Service.Client;
import Service.Menu;
import Service.Shop;
import Utils.AmplifierType;

public class Main {
	public static void main(String[] args) {
		Menu menu = Menu.getInstance();
		menu.showMenu();
	}
}