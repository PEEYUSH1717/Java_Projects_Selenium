package collection;

import java.util.*;

public class AppointmentScheduler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, String> appointments = new TreeMap<>();

        int choice;

        do {
            System.out.println("\nAppointment Menu:");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Remove Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. Next Appointment");
            System.out.println("6. Last Appointment");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Appointment Date & Time (yyyy-MM-dd HH:mm): ");
                    String dateTime = sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patient = sc.nextLine();

                    if (appointments.containsKey(dateTime)) {
                        System.out.println("Appointment already exists at this time.");
                    } else {
                        appointments.put(dateTime, patient);
                        System.out.println("Appointment added.");
                    }
                    break;

                case 2:
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments scheduled.");
                    } else {
                        System.out.println("Scheduled Appointments:");
                        for (Map.Entry<String, String> entry : appointments.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Appointment Date & Time to remove: ");
                    String removeTime = sc.nextLine();
                    if (appointments.remove(removeTime) != null) {
                        System.out.println("Appointment removed.");
                    } else {
                        System.out.println("No appointment found at that time.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Existing Appointment Date & Time to Reschedule: ");
                    String oldTime = sc.nextLine();
                    if (appointments.containsKey(oldTime)) {
                        String oldPatient = appointments.remove(oldTime);
                        System.out.print("Enter New Date & Time: ");
                        String newTime = sc.nextLine();
                        appointments.put(newTime, oldPatient);
                        System.out.println("Appointment rescheduled.");
                    } else {
                        System.out.println("No appointment found to reschedule.");
                    }
                    break;

                case 5:
                    if (!appointments.isEmpty()) {
                        String nextTime = appointments.firstKey();
                        System.out.println("Next Appointment:");
                        System.out.println(nextTime + " -> " + appointments.get(nextTime));
                    } else {
                        System.out.println("No upcoming appointments.");
                    }
                    break;

                case 6:
                    if (!appointments.isEmpty()) {
                        String lastTime = appointments.lastKey();
                        System.out.println("Last Appointment:");
                        System.out.println(lastTime + " -> " + appointments.get(lastTime));
                    } else {
                        System.out.println("No previous appointments.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
