package classes1;

public class employee {
	    String name;
	    int id;
	    String department;
	    void addEmployee(String n, int i, String d) {
	        name = n;
	        id = i;
	        department = d;
	    }
	    void showEmployee() {
	        System.out.println("Name: " + name);
	        System.out.println("ID: " + id);
	        System.out.println("Department: " + department);
	    }
	    public static void main(String[] args) {
	        employee e = new employee();

	        e.addEmployee("Tom Ford", 1001, "Automobile");
	        e.showEmployee();
	    }}
