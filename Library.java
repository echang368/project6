
import java.util.Scanner;



public class Library {
	
	static ArrayList<Book> books = new ArrayList<Book>();
	
	
	
	public static void main(String[] args){
		
		//ArrayList<Book> booksClone1 = new ArrayList<Book>();
        
        
		setBooks();
		
		
		
		for (int i=0;i<books.getSize();i++){
		    String title = books.get(i).getName();
		    System.out.println("Title: " + title);
		}
		
		Scanner input = new Scanner(System.in);
        String title;
        
		while (true) {
            System.out.print("What can I do for you?: ");
            String answer = input.nextLine();

            boolean quit = false;
            if (answer.equals("quit")){
                break;
            } else if (answer.equals("page sort")){
                pageSort();
            } else if (answer.equals("reviews")){
                reviewSort();
            } else if(answer.equals("subject search")){
                subjectSearch();
            } else if (answer.equals("year sort")){
                yearSort();
            } else if (answer.equals("add")){
                addBook();
            } else if (answer.equals("title search")){
                titleSearch();
            }
            
            else {
                System.out.println("Title not found. Try again.");
            }
        } 
      
	
		
	}
	
	public static void addBook() {
	    Scanner sc = new Scanner(System.in);
        System.out.println("Enter book information: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Year: ");
		int year = sc.nextInt();
		
		System.out.print("Pages: ");
		int pages = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Subject: ");
		String subject = sc.nextLine();
		while (!subject.equals("Programming") && !subject.equals("Data Structures") && 
			   !subject.equals("Algorithms") && !subject.equals("Operating Systems") &&
			   !subject.equals("Gaming")) {
			System.out.println("Invalid subject. Must be one of the following: Programming, Data Structures, Algorithms, Operating Systems, or Gaming");
			System.out.print("Subject: ");
			subject = sc.nextLine();
		}
		
		System.out.print("Review: ");
		double review = sc.nextDouble();
		while (review < 0.1 || review > 10.0) {
			System.out.println("Invalid review. Must be between 0.1 and 10.0");
			System.out.print("Review: ");
			review = sc.nextDouble();
		}
		
		// Adds the new book to the list
		books.add(new Book(name, year, pages, subject, review));
		
    }
    
    public static void setBooks(){
        books.add(new Book("In Cold Blood", 1965, 343, "Programming", 9.5));
        books.add(new Book("Overachievers", 2006, 448, "Programming", 9.6));
        books.add(new Book("Moby Dick", 1851, 427, "Data Structures", 8.0));
        books.add(new Book("Think and Grow Rich", 2001, 300, "Data Structures", 10.0));
        books.add(new Book("Life of Pi", 2002, 351, "Data Structures", 9.1));
        books.add(new Book("Pride and Prejudice", 1813, 280, "Algorithms", 8.9));
        books.add(new Book("To Kill a Mockingbird", 1960, 324, "Algorithms", 7.9));
        books.add(new Book("The Great Gatsby", 1925, 218, "Algorithms", 8.5));
        books.add(new Book("The Catcher in the Rye", 1951, 277, "Operating Systems", 8.4));
        books.add(new Book("1984", 1949, 328, "Operating Systems", 6.7));
        books.add(new Book("Brave New World", 1932, 288, "Operating Systems", 7.9));
        books.add(new Book("Animal Farm", 1945, 112, "Gaming", 9.9));
        books.add(new Book("The Grapes of Wrath", 1939, 456, "Gaming", 8.6));
        books.add(new Book("One Hundred Years of Solitude", 1967, 417, "Gaming", 7.5));
        books.add(new Book("Middlesex", 2002, 536, "Programming", 8.3));
        books.add(new Book("The God of Small Things", 1997, 321, "Programming", 8.2));
        books.add(new Book("Slaughterhouse-Five", 1969, 275, "Data Structures", 9.3));
        books.add(new Book("The Sun Also Rises", 1926, 260, "Algorithms", 9.4));
        books.add(new Book("A Farewell to Arms", 1929, 310, "Operating Systems", 7.8));
        books.add(new Book("For Whom the Bell Tolls", 1940, 480, "Gaming", 7.7));
    }
    
    public static void pageSort(){
        ArrayList<Book> pageSorted = new ArrayList<Book>();
            
            while (books.getSize() > 0) {
                int minPages = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getPages() < minPages) {
                    minPages = books.get(i).getPages();
                    minIndex = i;
                }
            }
                pageSorted.add(books.get(minIndex));
                books.remove(minIndex);
                
            }
            
            for (int i=0;i<pageSorted.getSize();i++) {
                String title = pageSorted.get(i).getName();
                System.out.println("Title: " + title);
            }
            setBooks();
    	    System.out.println(books.getSize());
    }
    
    public static void yearSort(){
        ArrayList<Book> yearSorted = new ArrayList<Book>();
		
		//This code uses a while loop and a inner for loop which uses the book arraylist and finds the minimum year 
		//and adds it to the yearSorted arraylist. The book is then removed from the books ArrayList and the process of finding the lowest number is repeated
		
		while (books.getSize() > 0) {
			int minYear = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 0; i < books.getSize(); i++) {
				if (books.get(i).getYear() < minYear) {
					minYear = books.get(i).getYear();
					minIndex = i;
				}
			}
			
			yearSorted.add(books.get(minIndex));
			books.remove(minIndex);
			
		}
		
		for (int i=0;i<yearSorted.getSize();i++){
		    String title = yearSorted.get(i).getName();
		    System.out.println("Title: " + title);
		}
		setBooks();
    }
    
    public static void reviewSort(){
        ArrayList<Book> reviewSorted = new ArrayList<Book>();
		
		while (books.getSize() > 0) {
			double minReview = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 0; i < books.getSize(); i++) {
				if (books.get(i).getReview() < minReview) {
					minReview = books.get(i).getReview();
					minIndex = i;
				}
			}
			
			reviewSorted.add(books.get(minIndex));
			books.remove(minIndex);
			
		}
		
		for (int i=0;i<reviewSorted.getSize();i++){
		    String title = reviewSorted.get(i).getName();
		    System.out.println("Title: " + title);
		}
		setBooks();
    }
    public static void subjectSearch(){
        Scanner scan = new Scanner(System.in);
        String subject;
        
		while (true) {
            System.out.print("Enter a subject: ");
            subject = scan.nextLine();

            boolean foundSubject = false;
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getSubject().equals(subject)) {
                    System.out.println("Name: " + books.get(i).getName());
                    foundSubject = true;
                }
            }

            if (foundSubject) {
                break;
            } else {
                System.out.println("Subject not found. Try again.");
            }
        }
    }
    public static void titleSearch(){
        Scanner scanTitle = new Scanner(System.in);
        String title;
        
		while (true) {
            System.out.print("Enter a Title: ");
            title = scanTitle.nextLine();

            boolean foundTitle = false;
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getName().equals(title)) {
                    System.out.println("Name: " + books.get(i).getName() + " Published: "+ books.get(i).getYear() + 
                    " Pages: " + books.get(i).getPages() + " Subject: " + books.get(i).getSubject()+ " Review: " + books.get(i).getReview());
                    
                    foundTitle = true;
                }
            }

            if (foundTitle) {
                break;
            } else {
                System.out.println("Title not found. Try again.");
            }
        } 
		
    }
    
}



