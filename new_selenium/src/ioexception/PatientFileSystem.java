package ioexception;

import java.io.*;
import java.util.Scanner;

class Patient1 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int id;
    String name;
    String disease;
    int age;

    public Patient1(int id, String name, String disease, int age) {
        this.id = id;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
        System.out.println("-------------------------");
    }
}

public class PatientFileSystem {
    static final String FILE_NAME = "patients.dat";
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
            sc.nextLine(); 

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
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            Patient p = new Patient(id, name, disease, age);

            File file = new File(FILE_NAME);
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos;

            // If file is empty, write stream header normally
            if (file.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                // If not empty, override header to avoid corruption
                oos = new ObjectOutputStream(fos) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }

            oos.writeObject(p);
            oos.close();

            System.out.println("Patient data serialized and saved.");

        } catch (IOException e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    // Deserialize and read all patients from file
    public static void readPatients() {
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println("\nAll Patients:");

            while (true) {
                try {
                    Patient1 p = (Patient1) ois.readObject();
                    p.display();
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

            ois.close();

        } catch (FileNotFoundException e) {
            System.out.println("No patient records found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading patient data: " + e.getMessage());
        }
    }
}
