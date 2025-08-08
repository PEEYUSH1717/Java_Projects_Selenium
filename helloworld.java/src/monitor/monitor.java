package monitor;

public class monitor {
    public static void main(String[] args) {
        int[] validPins = {1234, 5678, 1111};

        for (int pin : validPins) {
            System.out.println("Checking PIN: " + pin);
        }

        System.out.println("All saved PINs checked.");
    }
}