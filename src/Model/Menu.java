package Model;

import java.util.Scanner;

public final class Menu {
	private static Menu instance = null;
	private Menu(){}
	
	public synchronized static void showOptions(){
		//all the options 1...n
	}
	public synchronized static Menu getInstance(){
		if(instance == null)
			instance = new Menu();
		return instance;
	}
	public void showMenu(){
		Scanner input = new Scanner(System.in);
		String option = "";
		while(!option.equals("q")){
			showOptions();
			
			option = input.next();
			switch(option){
				//case ...:
					//break;
				default:
					System.out.println("Invalid option, try again!");
					break;
					
			}
		}
	}

}
