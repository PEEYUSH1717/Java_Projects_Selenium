package com.healthcare.module;

public class Cardiologist extends Doctor {

    public Cardiologist(String name) {
        super(name, "Cardiologist");
    }
    public void diagnose(Patient patient) {
        System.out.println(specialization + " " + name + " diagnosing patient: " + patient.getName());
        if (patient.getIllness().toLowerCase().contains("heart")) {
            System.out.println("Diagnosis: Heart-related issue");
        } else {
            System.out.println("Diagnosis: Not a heart issue. Refer to General Physician.");
        }
    }
}
