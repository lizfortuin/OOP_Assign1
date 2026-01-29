package sait.mms.manager;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import sait.mms.problemdomain.Movie;

public class MovieManager {
	// TODO displayMenu, addMovie, generateMovieListInYear, generateRandomMovieList, loadMovieList, saveMovieListToFile
	private ArrayList<Movie> movieList;
	private Scanner input;
	
	public MovieManager() {
		movieList = new ArrayList<>();
		input = new Scanner(System.in);
	}
	
	public void loadMovieList() {
		try {
			File file = new File("res/movies.txt");
			Scanner fileReader = new Scanner(file);
		
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine().trim();
				if (line.isEmpty()) continue;
			
				String[] parts = line.split(",");
				int duration = Integer.parseInt(parts[0].trim());
				String title = parts[1].trim();
				int year = Integer.parseInt(parts[2].trim());
			
				Movie m = new Movie(title, duration, year);
				movieList.add(m);
			}
		
			fileReader.close();
			System.out.println("Movies loaded successfully.");
		} catch (Exception e) {
			System.out.println("Error loading movies: " + e.getMessage());
		}
	}
	
	public void addMovie() {
		try {
			System.out.print("Enter duration (minutes): ");
			int duration = Integer.parseInt(input.nextLine());
			if (duration <= 0) {
				System.out.println("Duration must be positive.");
				return;
			}
			
			System.out.println("Enter title: ");
			String title = input.nextLine().trim();
			if (title.isEmpty()) {
				System.out.println("Title cannot be empty.");
				return;
			}
			
			System.out.println("Enter year: ");
			int year = Integer.parseInt(input.nextLine());
			if (year <= 0) {
				System.out.println("Year must be positive.");
				return;
			}
			
			Movie m = new Movie(title, duration, year);
			movieList.add(m);
			
			System.out.println(title + " added");
			
		} catch (Exception e) {
			System.out.println("Invalid Input.");
		}
	}
	
	public void displayMenu() {
		int choice = 0;
		
		while (choice != 4) {
			System.out.println("\nMovie Management System");
			System.out.println("1. Add New Movie");
			System.out.println("2. List Movies By Year");
			System.out.println("3. Generate Random Movie List");
			System.out.println("4. Exit");
			System.out.println("Enter choice: ");
			
			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input.");
				continue;
			}
			switch(choice) {
			case 1:
				addMovie();
				break;
			case 2:
				generateMovieListInYear();
				break;
			case 4:
				saveMovieListToFile();
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
	
	public void generateMovieListInYear() {
		System.out.println("Enter year: ");
		int year = Integer.parseInt(input.nextLine());
		
		boolean found = false;
		
		for (Movie m : movieList) {
			if (m.getYear() == year) {
				System.out.println(m.getTitle() + " (" + m.getDuration() + " min)");
				found = true;
			}
		}
		if (!found) {
			System.out.println("No movies found for that year.");
		}
	}
	
	public void generateRandomMovieList() {
		System.out.println("How many movies? ");
		int count = Integer.parseInt(input.nextLine());
		
		if (count <= 0 || count > movieList.size()) {
			System.out.println("Invalid number.");
			return;
		}
		
		Random rand = new Random();
		
		for (int i = 0; i < count; i++) {
			Movie m = movieList.get(rand.nextInt(movieList.size()));
			System.out.println(m.getTitle() + " (" + m.getDuration() + " min)");
		}
	}
	
	public void saveMovieListToFile() {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("res/movies.txt"));
			
			for (Movie m : movieList) {
				writer.println(m.getDuration() + "," + m.getTitle() + "," + m.getYear());
				
			}
			writer.close();
			System.out.println("Movies saved.");
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
}
