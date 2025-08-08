package collection;

import java.util.HashMap;

class Patient {
    private int id;
    private String name;
    private String disease;

    public Patient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDisease() {
        return disease;
    }
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Disease: " + disease;
    }
}
public class HospitalMap {
    public static void main(String[] args) {

        HashMap<Integer, Patient> patientMap = new HashMap<>();

        patientMap.put(101, new Patient(101, "mike", "Cold"));
        patientMap.put(102, new Patient(102, "john", "Fever"));
        patientMap.put(103, new Patient(103, "leo", "Flu"));

        System.out.println("\nGet Patient With ID 104:");
        System.out.println(patientMap.get(104)); 

        System.out.println("\nDoes Patient With ID 103 exist?");
        System.out.println(patientMap.containsKey(103)); 
    }
}
