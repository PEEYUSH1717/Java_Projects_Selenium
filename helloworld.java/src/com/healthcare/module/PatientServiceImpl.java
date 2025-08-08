package com.healthcare.module;

	import java.util.HashMap;
	import java.util.Map;

	public class PatientServiceImpl implements PatientService {
	    private Map<Integer, Patient> patientMap = new HashMap<>();

	    public void registerPatient(Patient patient) {
	        patientMap.put(patient.getId(), patient);
	        System.out.println("Patient " + patient.getName() + " registered.");
	    }
	    public void showPatientDetails(int patientId) {
	        Patient p = patientMap.get(patientId);
	        if (p != null) {
	            System.out.println("ID: " + p.getId());
	            System.out.println("Name: " + p.getName());
	            System.out.println("Age: " + p.getAge());
	            System.out.println("Illness: " + p.getIllness());
	        } else {
	            System.out.println("Patient not found.");
	        }
	    }
	}
