package encapsulation;

public class voter {
	    private String name;
	    private int age;
	    private boolean voted = false;

	    public void setDetails(String n, int a) {
	        name = n;
	        age = a;
	    }

	    public void vote() {
	        if (age >= 18 && voted == false) {
	            voted = true;
	            System.out.println(name + " voted.");
	        } else if (voted == true) {
	            System.out.println(name + " already voted.");
	        } else {
	            System.out.println(name + " is not eligible.");
	        }
	    }
	    public static void main(String[] args) {
	        voter v1 = new voter();
	        v1.setDetails("John", 20);
	        v1.vote();   
	        v1.vote();  

	        voter v2 = new voter();
	        v2.setDetails("Tom", 16);
	        v2.vote();   
	    }
	}
