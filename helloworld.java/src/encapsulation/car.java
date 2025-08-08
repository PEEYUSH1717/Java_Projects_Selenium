package encapsulation;

public class car {
	    private boolean engineOn;
	    private int speed;
	    private double fuelLevel;

	    public void setCarStatus(boolean engine, int spd, double fuel) {
	        engineOn = engine;
	        speed = spd;
	        fuelLevel = fuel;
	    }

	    public void getCarStatus() {
	        System.out.println("Engine On: " + engineOn);
	        System.out.println("Speed: " + speed + " km/h");
	        System.out.println("Fuel Level: " + fuelLevel + " liters");
	    }

	    public static void main(String[] args) {
	        car myCar = new car();

	        myCar.setCarStatus(true, 110, 15.5);

	        System.out.println("Car Status:");
	        myCar.getCarStatus();
	    }
	}
