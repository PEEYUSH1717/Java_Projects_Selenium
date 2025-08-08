package collection;

import java.util.Scanner;
import java.util.TreeSet;

public class AppointmentManager {

    static class Appointment implements Comparable<Appointment> {
        private String dateTime;
        private String patientName;

        public Appointment(String dateTime, String patientName) {
            this.dateTime = dateTime;
            this.patientName = patientName;
        }

        public String getDateTime() {
            return dateTime;
        }

        public String getPatientName() {
            return patientName;
        }

        public void display() {
            System.out.println("Appointment: " + dateTime + " | Patient: " + patientName);
        }

        public int compareTo(Appointment other) {
            return this.dateTime.compareTo(other.dateTime);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Appointment) {
                Appointment other = (Appointment) obj;
                return this.dateTime.equalsIgnoreCase(other.dateTime);
            }
            return false;
        }

        public int hashCode() {
            return dateTime.toLowerCase().hashCode();
        }
    }

    public static void main(String[] args) {
        TreeSet<Appointment> appointments = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAppointment Menu:");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments (Sorted)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Appointment Date & Time (dd-MM-yyyy HH:mm): ");
                    String dateTime = sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    Appointment newAppt = new Appointment(dateTime, name);

                    if (appointments.contains(newAppt)) {
                        System.out.println("Appointment already exists at this date and time.");
                    } else {
                        appointments.add(newAppt);
                        System.out.println("Appointment added successfully.");
                    }
                    break;

                case 2:
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments scheduled.");
                    } else {
                        System.out.println("Scheduled Appointments:");
                        for (Appointment a : appointments) {
                            a.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
