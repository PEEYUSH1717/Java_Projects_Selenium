package new_program;

public class student {

	    static String college = "ABC College";

	    int rollNo;

	    void showDetails() {
	        String name = "Peeyush";

	        System.out.println("Name: " + name);
	        System.out.println("Roll Number: " + rollNo);
	        System.out.println("College: " + college);
	    }

	    public static void main(String[] args) {
	        Student s = new Student();

	        s.rollNo = 101;

	        s.showDetails();
	    }
	}

}
