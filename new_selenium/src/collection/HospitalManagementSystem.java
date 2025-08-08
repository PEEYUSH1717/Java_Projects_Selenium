package collection;

import java.util.HashMap;
import java.util.Scanner;

public class HospitalManagementSystem {

    static class Patient {
        private String id;
        private String name;

        public Patient(String id, String name) {
            this.id = id;
            this.name = name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String toString() {
            return "ID: " + id + " | Name: " + name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Patient> patients = new HashMap<>();

        int choice;

        do {
            System.out.println("\nHospital Management Menu ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Retrieve Patient");
            System.out.println("4. Remove Patient");
            System.out.println("5. List All Patients");
            System.out.println("6. Count Patients");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    String id = sc.nextLine();
                    if (patients.containsKey(id)) {
                        System.out.println("Patient with ID " + id + " already exists!");
                    } else {
                        System.out.print("Enter Patient Name: ");
                        String name = sc.nextLine();
                        patients.put(id, new Patient(id, name));
                        System.out.println("Patient added successfully.");
                    }
                    break;
                case 2: 
                    System.out.print("Enter Patient ID to update: ");
                    id = sc.nextLine();
                    if (patients.containsKey(id)) {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        patients.get(id).setName(newName);
                        System.out.println("Patient updated.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3: 
                    System.out.print("Enter Patient ID to search: ");
                    id = sc.nextLine();
                    if (patients.containsKey(id)) {
                        System.out.println("Patient Found: " + patients.get(id));
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Patient ID to remove: ");
                    id = sc.nextLine();
                    if (patients.containsKey(id)) {
                        patients.remove(id);
                        System.out.println("Patient removed.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 5: 
                    if (patients.isEmpty()) {
                        System.out.println("No patients registered.");
                    } else {
                        System.out.println("All Registered Patients:");
                        for (Patient p : patients.values()) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 6: 
                    System.out.println("Total Registered Patients: " + patients.size());
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
