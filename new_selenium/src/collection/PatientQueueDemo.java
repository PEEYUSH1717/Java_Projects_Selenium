package collection;

import java.util.LinkedList;
import java.util.Scanner;

public class PatientQueueDemo {
    public static void main(String[] args) {

        LinkedList<String> patientQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nHospital Patient Queue Menu:");
            System.out.println("1. Add New Normal Patient");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Check if a Patient is in Queue");
            System.out.println("5. Show Total Number of Patients");
            System.out.println("6. Clear the Entire Queue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patient = sc.nextLine().trim();
                    if (!patient.isEmpty()) {
                        patientQueue.addLast(patient);
                        System.out.println("Patient added to queue.");
                    } else {
                        System.out.println("Name cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter emergency patient name: ");
                    String emergencyPatient = sc.nextLine().trim();
                    if (!emergencyPatient.isEmpty()) {
                        patientQueue.addFirst(emergencyPatient);
                        System.out.println("Emergency patient added to front of queue.");
                    } else {
                        System.out.println("Name cannot be empty.");
                    }
                    break;

                case 3:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        System.out.println("Patients in queue:");
                        for (String p : patientQueue) {
                            System.out.println("- " + p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter name to check: ");
                    String searchName = sc.nextLine().trim();
                    if (patientQueue.contains(searchName)) {
                        System.out.println("Patient is in the queue.");
                    } else {
                        System.out.println("Patient not found in queue.");
                    }
                    break;

                case 5:
                    System.out.println("Total patients in queue: " + patientQueue.size());
                    break;

                case 6:
                    patientQueue.clear();
                    System.out.println("All patients removed. Queue is now empty.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
