
public class Book {
	
	private String name;
	private int year;
	private int pages;
	private String subject;
	private double review;
	
	public Book(String name, int year, int pages, String subject, double review) {
		this.name = name;
		this.year = year;
		this.pages = pages;
		this.subject = subject;
		this.review = review;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getPages() {
		return pages;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public double getReview() {
		return review;
	}
	
	
}
