package ioexception;

import java.io.*;
import java.util.*;

class Patient implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
    String name;
    String disease;
    int age;

    public Patient(int id, String name, String disease, int age) {
        this.id = id;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Disease: " + disease + ", Age: " + age;
    }
}
public class Paitientapp {
    static final String FILE_NAME = "patients_list.dat";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patientList = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (file.exists() && file.length() > 0) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                patientList = (ArrayList<Patient>) in.readObject();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("Error loading previous data: " + e.getMessage());
        }

        int choice = 0;

        do {
            System.out.println("\nPatient Management Menu:");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Disease: ");
                        String disease = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());

                        Patient p = new Patient(id, name, disease, age);
                        patientList.add(p);
                        try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
                            out.writeObject(patientList);
                            out.close();
                            System.out.println("Patient added and saved.");
                        } catch (IOException e) {
                            System.out.println("Error saving patient: " + e.getMessage());
                        }
                        break;

                    case 2:
                        if (patientList.isEmpty()) {
                            System.out.println("No patients found.");
                        } else {
                            System.out.println("All Patients:");
                            for (Patient pat : patientList) {
                                System.out.println(pat); 
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric input.");
            }

        } while (choice != 3);

        sc.close();
    }
}

