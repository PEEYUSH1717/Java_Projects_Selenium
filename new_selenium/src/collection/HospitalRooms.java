package collection;

import java.util.TreeSet;

public class HospitalRooms {
    public static void main(String[] args) {

        TreeSet<Integer> rooms = new TreeSet<>();

        rooms.add(203);
        rooms.add(101);
        rooms.add(305);
        rooms.add(102);
        rooms.add(201);

        System.out.println("Available Rooms (Descending Order):");
        for (int room : rooms.descendingSet()) {
            System.out.println("Room: " + room);
        }

        System.out.println("\nHighest Room Number: " + rooms.last());
        System.out.println("Lowest Room Number: " + rooms.first());
    }
}
