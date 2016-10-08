package javaPractice;

//A Java program to demonstrate use of Comparable
//import java.io.*;
import java.util.*;

//A class 'Movie' that implements Comparable
 class Main1 implements Comparable<Main1> {
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	public int compareTo(Main1 m) {
		return m.year - this.year;
	}

	// Constructor
	public Main1(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	// Getter methods for accessing private data
	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
}

// Driver class
public class Movie {
	public static void main(String[] args) {
		Thread t = new Thread()
		ArrayList<Main1> list = new ArrayList<Main1>();
		list.add(new Main1("Force Awakens", 8.3, 2015));
		list.add(new Main1("Star Wars", 8.7, 1977));
		list.add(new Main1("Empire Strikes Back", 8.8, 1980));
		list.add(new Main1("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (Main1 movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " "
					+ movie.getYear());
		}
	}
}