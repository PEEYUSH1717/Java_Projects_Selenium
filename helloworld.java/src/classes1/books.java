package classes1;

public class books {
	    String title;
	    String author;
	    int price;
	    void addBook(String t, String a, int p) {
	        title = t;
	        author = a;
	        price = p;
	    }
	    void showBook() {
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	        System.out.println("Price: ₹" + price);
	    }
	    public static void main(String[] args) {
	        books b = new books();
	        b.addBook("Harry Potter", "J.K. Rowling", 900);
	        b.showBook(); 
	    }}
