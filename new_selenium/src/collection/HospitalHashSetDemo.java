package collection;

import java.util.HashSet;
import java.util.Scanner;

public class HospitalHashSetDemo {

    public static void main(String[] args) {
        HashSet<String> patientSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital HashSet Menu:");
            System.out.println("1. Add New Normal Patient");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. Remove Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Check if Patient Exists");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();
                    if (patientSet.add(name)) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println("Patient already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter emergency patient name: ");
                    String emergency = sc.nextLine();
                    if (patientSet.add(emergency)) {
                        System.out.println("Emergency patient added.");
                    } else {
                        System.out.println("Patient already in list!");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String toRemove = sc.nextLine();
                    if (patientSet.remove(toRemove)) {
                        System.out.println("Patient removed.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    if (patientSet.isEmpty()) {
                        System.out.println("No patients in the list.");
                    } else {
                        System.out.println("All patients:");
                        for (String p : patientSet) {
                            System.out.println("- " + p);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter name to check: ");
                    String search = sc.nextLine();
                    if (patientSet.contains(search)) {
                        System.out.println("Patient is in the list.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
