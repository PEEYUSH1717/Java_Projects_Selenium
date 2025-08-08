package collection;

import java.util.LinkedList;
import java.util.Scanner;

public class SmartHospitalQueue {
    static class Patient {
        private String id;
        private String name;

        public Patient(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void display() {
            System.out.println("ID: " + id + " | Name: " + name);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Patient) {
                Patient other = (Patient) obj;
                return this.id.equalsIgnoreCase(other.id);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList<Patient> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSmart Hospital Queue Menu:");
            System.out.println("1. Add New Normal Patient");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. Cancel Appointment (Remove by ID)");
            System.out.println("4. View All Patients");
            System.out.println("5. View Next Patient");
            System.out.println("6. View Last Patient");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();

                    Patient newPatient = new Patient(id, name);
                    if (queue.contains(newPatient)) {
                        System.out.println("Patient with this ID already exists!");
                    } else {
                        queue.addLast(newPatient);
                        System.out.println("Patient added to queue.");
                    }
                    break;

                case 2:
                    System.out.print("Enter emergency patient ID: ");
                    String eId = sc.nextLine();
                    System.out.print("Enter emergency patient name: ");
                    String eName = sc.nextLine();

                    Patient emergencyPatient = new Patient(eId, eName);
                    if (queue.contains(emergencyPatient)) {
                        System.out.println("Patient with this ID already exists!");
                    } else {
                        queue.addFirst(emergencyPatient);
                        System.out.println("Emergency patient added to front of queue.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to cancel appointment: ");
                    String cancelId = sc.nextLine();
                    boolean removed = queue.removeIf(p -> p.getId().equalsIgnoreCase(cancelId));
                    if (removed) {
                        System.out.println("Patient removed from queue.");
                    } else {
                        System.out.println("No patient found with this ID.");
                    }
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        System.out.println("All Patients in Queue:");
                        for (Patient p : queue) {
                            p.display();
                        }
                    }
                    break;

                case 5:
                    if (!queue.isEmpty()) {
                        System.out.print("Next Patient: ");
                        queue.getFirst().display();
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 6:
                    if (!queue.isEmpty()) {
                        System.out.print("Last Patient: ");
                        queue.getLast().display();
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
