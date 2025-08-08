package collection;

import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String disease;

    public Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
        System.out.println("Disease: " + disease);

    }

    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            Patient other = (Patient) obj;
            return this.name.equalsIgnoreCase(other.name);
        }
        return false;
    }
}

public class HospitalOPD {
    public static void main(String[] args) {
        ArrayList<Patient> patientList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital OPD Menu");
            System.out.println("1.  Add New Patient");
            System.out.println("2.  View All Patients");
            System.out.println("3.  View Patient by Index");
            System.out.println("4.  Update Patient Disease");
            System.out.println("5.  Remove Patient by Index");
            System.out.println("6.  Remove Patient by Name");
            System.out.println("7.  Check if Patient Exists");
            System.out.println("8.  Show Total Patients");
            System.out.println("9.  Clear All Records");
            System.out.println("10. Find First/Last Index of a Patient");
            System.out.println("11. Check if List is Empty");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age;
                    if (sc.hasNextInt()) {
                        age = sc.nextInt();
                    } else {
                        System.out.println("Invalid age! Skipping this entry.");
                        sc.nextLine(); 
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();

                    patientList.add(new Patient(name, age, disease));
                    System.out.println("Patient added successfully.");
                }

                case 2 -> {
                    if (patientList.isEmpty()) {
                        System.out.println("No patients to display.");
                    } else {
                        for (Patient p : patientList) {
                            p.displayDetails();
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter index: ");
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index >= 0 && index < patientList.size()) {
                            patientList.get(index).displayDetails();
                        } else {
                            System.out.println("Invalid index!");
                        }
                    } else {
                        System.out.println("Please enter a valid number!");
                        sc.nextLine(); 
                    }
                }

                case 4 -> {
                    System.out.print("Enter patient name to update disease: ");
                    String updateName = sc.nextLine();
                    boolean updated = false;
                    for (Patient p : patientList) {
                        if (p.getName().equalsIgnoreCase(updateName)) {
                            System.out.print("Enter new disease: ");
                            String newDisease = sc.nextLine();
                            p.setDisease(newDisease);
                            System.out.println("Disease updated successfully.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Patient not found.");
                    }
                }

                case 5 -> {
                    System.out.print("Enter index to remove patient: ");
                    if (sc.hasNextInt()) {
                        int removeIndex = sc.nextInt();
                        sc.nextLine();
                        if (removeIndex >= 0 && removeIndex < patientList.size()) {
                            patientList.remove(removeIndex);
                            System.out.println("Patient removed.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("Please enter a valid number!");
                        sc.nextLine();
                    }
                }

                case 6 -> {
                    System.out.print("Enter name to remove: ");
                    String removeName = sc.nextLine();
                    boolean removed = patientList.removeIf(p -> p.getName().equalsIgnoreCase(removeName));
                    if (removed) {
                        System.out.println("Patient removed.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                }

                case 7 -> {
                    System.out.print("Enter name to check: ");
                    String checkName = sc.nextLine();
                    boolean exists = patientList.contains(new Patient(checkName, 0, ""));
                    System.out.println("Patient exists? " + exists);
                }

                case 8 -> System.out.println("Total number of patients: " + patientList.size());

                case 9 -> {
                    patientList.clear();
                    System.out.println("All patient records cleared.");
                }

                case 10 -> {
                    System.out.print("Enter patient name: ");
                    String search = sc.nextLine();
                    int firstIndex = -1;
                    int lastIndex = -1;
                    for (int i = 0; i < patientList.size(); i++) {
                        if (patientList.get(i).getName().equalsIgnoreCase(search)) {
                            if (firstIndex == -1) firstIndex = i;
                            lastIndex = i;
                        }
                    }
                    if (firstIndex != -1) {
                        System.out.println("First index: " + firstIndex);
                        System.out.println("Last index : " + lastIndex);
                    } else {
                        System.out.println("Patient not found.");
                    }
                }

                case 11 -> System.out.println("Is patient list empty? " + patientList.isEmpty());

                case 12 -> {
                    System.out.println("Exiting. Thank you!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice! Please select 1 to 12.");
            }}}}
