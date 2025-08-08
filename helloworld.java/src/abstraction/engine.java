package abstraction;
	import java.util.Scanner;

	abstract class Vehicle {
	    abstract void startEngine();
	}
	class Car extends Vehicle {
	    void startEngine() {
	        System.out.println("Car engine started.");
	    }
	}
	public class engine {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter car name: ");
	        String carName = scanner.nextLine();

	        Vehicle vehicle = new Car();
	        System.out.println(carName + " is ready.");
	        vehicle.startEngine();

	        scanner.close();
	    }
	}
