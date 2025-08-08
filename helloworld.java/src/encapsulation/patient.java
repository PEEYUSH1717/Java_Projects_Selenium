package encapsulation;

public class patient {
	    private String name;
	    private int age;
	    private String disease;

	    public void setDetails(String n, int a, String d) {
	        name = n;
	        age = a;
	        disease = d;
	    }

	    public void getDetails() {
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Disease: " + disease);
	    }
	    public static void main(String[] args) {
	        patient p1 = new patient();
	        p1.setDetails("Tom", 25, "Fever");

	        System.out.println("Patient Record:");
	        p1.getDetails();
	    }
	}
