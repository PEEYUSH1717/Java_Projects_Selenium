package com.healthcare.module;

public class HealthcareMain {
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Rengoku", 30, "Heart Pain");
        Patient p2 = new Patient(2, "Nezuko", 25, "Cough");

        PatientService service = new PatientServiceImpl();
        service.registerPatient(p1);
        service.registerPatient(p2);

        service.showPatientDetails(1);
        service.showPatientDetails(2);

        Doctor doc1 = new GeneralPhysician("Dr. Tom");
        Doctor doc2 = new Cardiologist("Dr. John");

        doc1.diagnose(p1);
        doc2.diagnose(p1);
        doc1.diagnose(p2);
        doc2.diagnose(p2);
    }
}
