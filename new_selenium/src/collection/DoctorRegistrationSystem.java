package collection;

import java.util.HashSet;
import java.util.Scanner;

public class DoctorRegistrationSystem {

    static class Doctor {
        private String licenseNumber;
        private String name;
        private String department;

        public Doctor(String licenseNumber, String name, String department) {
            this.licenseNumber = licenseNumber;
            this.name = name;
            this.department = department;
        }

        public String getLicenseNumber() {
            return licenseNumber;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public void display() {
            System.out.println("License: " + licenseNumber + " | Name: " + name + " | Department: " + department);
        }
        public boolean equals(Object obj) {
            if (obj instanceof Doctor) {
                Doctor other = (Doctor) obj;
                return this.licenseNumber.equalsIgnoreCase(other.licenseNumber);
            }
            return false;
        }
        public int hashCode() {
            return licenseNumber.toLowerCase().hashCode();
        }
    }
    public static void main(String[] args) {
        HashSet<Doctor> registeredDoctors = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDoctor Registration Menu:");
            System.out.println("1. Register New Doctor");
            System.out.println("2. View All Registered Doctors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor License Number: ");
                    String license = sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    Doctor newDoc = new Doctor(license, name, dept);

                    if (registeredDoctors.contains(newDoc)) {
                        System.out.println("Doctor with this license number already registered!");
                    } else {
                        registeredDoctors.add(newDoc);
                        System.out.println("Doctor registered successfully.");
                    }
                    break;
                    
                case 2:
                    if (registeredDoctors.isEmpty()) {
                        System.out.println("No doctors registered yet.");
                    } else {
                        System.out.println("Registered Doctors:");
                        for (Doctor d : registeredDoctors) {
                            d.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! ");
            }

        } while (choice != 3);

        sc.close();
    }}
