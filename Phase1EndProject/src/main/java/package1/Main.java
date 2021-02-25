package package1;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("============================================================================================================");
		System.out.println("Welcome to the prototype file manipulation system.");
		System.out.println("This project was finished February 24, 2021.");
		System.out.println("This prototype was commisioned by Company Lockers Pvt. Ltd.");
		System.out.println("The development team: HCL Java Fullstack Developer Benjamin Shumate.");
		System.out.println("This application will place a default directory and file in a default location on your computer.");
		System.out.println("Upon choosing the close operation the default directory and any files within will be deleted.");
		System.out.println("You will now be redirected to the main menu.");
		Methods m = new Methods();
		m.menu();
	}
}
