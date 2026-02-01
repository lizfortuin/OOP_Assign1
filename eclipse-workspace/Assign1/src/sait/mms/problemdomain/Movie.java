package sait.mms.problemdomain;

public class Movie {
	private String title;
	private int duration;
	private int year;
	
	public Movie(String title, int duration, int year) {
		this.title = title;
		this.duration = duration;
		this.year = year;
	}

	public String getTitle() {
		return title;}
	public int getDuration(){
		return duration;}
	public int getYear() {
		return year;}

	public void setTitle(String title) {
		this.title = title;}
	public void setDuration(int duration) {
		this.duration = duration;}
	public void setYear(int year) {
		this.year = year;}
	
	@Override 
	public String toString() {
		return title + ", " + duration + ", " + year;
	}
	
}
