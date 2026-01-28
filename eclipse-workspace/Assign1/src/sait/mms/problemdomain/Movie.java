package sait.mms.problemdomain;

public class Movie {
	private int duration;
	private String name;
	private int year;
	
	public Movie(int duration, String name, int year) {
		this.duration = duration;
		this.name = name;
		this.year = year;
	}
	
	public int getDuration(){
		return duration;}
	public String getName() {
		return name;}
	public int getYear() {
		return year;}
	
	public void setDuration(int duration) {
		this.duration = duration;}
	public void setName(String name) {
		this.name = name;}
	public void setYear(int year) {
		this.year = year;}
	
	@Override 
	public String toString() {
		return duration + ", " + name + ", " + year;
	}
	
}
