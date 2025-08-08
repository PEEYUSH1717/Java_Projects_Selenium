package collection;

import java.util.HashSet;
import java.util.Scanner;

public class HospitalPatientRegistration {

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
        public int hashCode() {
            return id.toLowerCase().hashCode();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Patient> registeredPatients = new HashSet<>();
        int choice;

        do {
            System.out.println("\nHospital Patient Registration System:");
            System.out.println("1. Register New Patient");
            System.out.println("2. View All Registered Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    Patient newPatient = new Patient(id, name);

                    if (registeredPatients.contains(newPatient)) {
                        System.out.println("Patient with ID " + id + " is already registered.");
                    } else {
                        registeredPatients.add(newPatient);
                        System.out.println("Patient added to the system.");
                    }
                    break;

                case 2:
                    if (registeredPatients.isEmpty()) {
                        System.out.println("No patients registered yet.");
                    } else {
                        System.out.println("List of Registered Patients:");
                        for (Patient p : registeredPatients) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-3.");
            }

        } while (choice != 3);

        sc.close();
    }
}
