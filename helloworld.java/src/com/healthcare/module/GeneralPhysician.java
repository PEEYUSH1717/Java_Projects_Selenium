package com.healthcare.module;

public class GeneralPhysician extends Doctor {

    public GeneralPhysician(String name) {
        super(name, "General Physician");
    }
    public void diagnose(Patient patient) {
        System.out.println(specialization + " " + name + " diagnosing patient: " + patient.getName());
        System.out.println("Diagnosis: " + patient.getIllness());
    }
}
