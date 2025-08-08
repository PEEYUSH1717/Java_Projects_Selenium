package LambdaCalculator;
	import java.util.*;

	class Employee {
	    String name;
	    double salary;
	  
	    Employee(String name, double salary) {
	        this.name = name;
	        this.salary = salary;
	    }
	    public String toString() {
	        return name + " - " + salary;
	    }}
	public class array {
	    public static void main(String[] args) {
	        List<Employee> list = new ArrayList<>();
	        list.add(new Employee("Johnny", 40000));
	        list.add(new Employee("mike", 60000));
	        list.add(new Employee("stewart", 50000));

	        Collections.sort(list, (a, b) -> (int)(a.salary - b.salary));
	        System.out.println("Sorted by salary (ascending):");
	        for (Employee e : list) {
	            System.out.println(e);
	        }
	        Collections.sort(list, (a, b) -> (int)(b.salary - a.salary));

	        System.out.println("\nSorted by salary (descending):");
	        for (Employee e : list) {
	            System.out.println(e);
	        }}}
