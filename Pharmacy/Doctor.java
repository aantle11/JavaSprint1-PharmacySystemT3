package Pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization + ", Patients: " + patients.size());
    }
}