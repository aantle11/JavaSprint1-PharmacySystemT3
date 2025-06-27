package Pharmacy;

import java.time.LocalDate;

public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication, LocalDate issueDate) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = issueDate;
        this.expiryDate = issueDate.plusYears(1);
    }

    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public Medication getMedication() { return medication; }
    public LocalDate getExpiryDate() {
    return expiryDate;
}

    public void displayInfo() {
        System.out.println("Prescription ID: " + id + ", Doctor: " + doctor.getName() +
                ", Patient: " + patient.getName() + ", Medication: " + medication.getName() +
                ", Issued: " + issueDate + ", Expires: " + expiryDate);
    }
}