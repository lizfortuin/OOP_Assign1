package sait.mms.application;

//imports
import java.util.Scanner;
//
public class AppDriver {

	public static void main(String[] args) {
		
		//attributes
		boolean systemOn = true;
		
		//scanners
		Scanner selectScan = new Scanner(System.in); //scanner for management system option
		Scanner duration = new Scanner(System.in); //scanner for movie duration
		
		//while loop that keeps program running until systemOn is false
		while (systemOn) {
			
			//placeholder for displayMenu method from MovieManager Class
			System.out.println("Movie Management System");
			System.out.println("	1. Add New Movie");
			System.out.println("	2. Generate List of Movies in a Year");
			System.out.println("	3. Generate List of Random Movies");
			System.out.println("	4. Exit");
			
			System.out.print("Enter an Option: ");
			
			//selection input as an int
			int option = selectScan.nextInt(); 
			
			// if /else if/ else statements for each option
			if (option == 1) { //user inputs 1
				
				System.out.println(" ");
				System.out.println("Option '1. Add New Movie' Selected");
			}
			else if (option == 2) { //user inputs 2
				System.out.println(" ");
				System.out.println("Option '2. Generate List of Movies in a Year' Selected");
			}
			else if (option ==  3) { //user inputs 3
				System.out.println(" ");
				System.out.println("Option '3. Generate List of Random Movies' Selected");
			}
			else if (option == 4) { //user inputs 4, ends the program
				System.out.println(" ");
				System.out.println("Option '4. Exit' Selected");
				System.out.println("Thank you for using Movie Manager System!");
				systemOn = false;
			}
			else if (option < 1) { //user inputs a number not part of selection
				System.out.println("Invalid option!");
			}
			else if (option > 4) { //user inputs a number not part of selection
				System.out.println("Invalid option!");
			}
			
		}

	}
}
