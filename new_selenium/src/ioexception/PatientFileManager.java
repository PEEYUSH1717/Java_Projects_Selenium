package ioexception;

import java.io.*;
import java.util.Scanner;

public class PatientFileManager {
    static final String FILE_NAME = "patients.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nPatient Management Menu:");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    readPatients();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }
    public static void addPatient() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(writer);

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            bw.write(id + "," + name + "," + disease + "," + age);
            bw.newLine();

            bw.close();
            System.out.println("Patient data saved to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }}
    public static void readPatients() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No patient records found.");
                return;
            }

            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("\nAll Patients:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("ID: " + parts[0]);
                System.out.println("Name: " + parts[1]);
                System.out.println("Disease: " + parts[2]);
                System.out.println("Age: " + parts[3]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
