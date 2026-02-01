package sait.mms.application;

//imports
import sait.mms.manager.MovieManager;

//
public class AppDriver {

	public static void main(String[] args) {
		
		//create new manager object
		MovieManager manager = new MovieManager();
		
		//call displayMenu method from the MovieManager class
		manager.displayMenu();

	}
}

