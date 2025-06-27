package Pharmacy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    public MedicationTrackingSystem() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    // Add / Delete patient, medication or doctor to system
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Edit patient, medication or doctor details
    public void deleteDoctor(int id) {
        doctors.removeIf(d -> d.getId() == id);
    }

    public void deletePatient(int id) {
        patients.removeIf(p -> p.getId() == id);
    }

    public void deleteMedication(int id) {
        medications.removeIf(m -> m.getId() == id);
    }

    // Search by name
    public void searchDoctor(String name) {
        for (Doctor d : doctors)
            if (d.getName().toLowerCase().contains(name.toLowerCase()))
                d.displayInfo();
    }

    public void searchPatient(String name) {
        for (Patient p : patients)
            if (p.getName().toLowerCase().contains(name.toLowerCase()))
                p.displayInfo();
    }

    public void searchMedication(String name) {
        for (Medication m : medications)
            if (m.getName().toLowerCase().contains(name.toLowerCase()))
                m.displayInfo();
    }

    // Accept prescription
    public void addPrescription(Prescription p) {
        prescriptions.add(p);
        p.getPatient().addPrescription(p);
    }

    // Add patient to doctor list
    public void assignPatientToDoctor(Patient p, Doctor d) {
        d.addPatient(p);
    }

    // Generate report
    public void generateSystemReport() {
        System.out.println("\n--- Doctors ---");
        for (Doctor d : doctors) d.displayInfo();

        System.out.println("\n--- Patients ---");
        for (Patient p : patients) p.displayInfo();

        System.out.println("\n--- Medications ---");
        for (Medication m : medications) m.displayInfo();

        System.out.println("\n--- Prescriptions ---");
        for (Prescription p : prescriptions) p.displayInfo();
    }

    // Check to see if any drug is exspired in system
    public void generateExpiredMedicationsReport() {
        System.out.println("\n--- Expired Medications ---");
        for (Medication m : medications)
            if (m.isExpired()) m.displayInfo();
    }

    // All prescriptions for a specific doctor
    public void printPrescriptionsByDoctor(int doctorId) {
        System.out.println("\n--- Prescriptions by Doctor ID " + doctorId + " ---");
        for (Prescription p : prescriptions)
            if (p.getDoctor().getId() == doctorId)
                p.displayInfo();
    }

    // Report of all prescriptions for past year
    public void summarizePatientPrescriptionsLastYear() {
        System.out.println("\n--- Prescription Summary (Past Year) ---");
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

        for (Patient p : patients) {
            System.out.println("Patient: " + p.getName());
            for (Prescription pres : p.getPrescriptions()) {
                if (pres != null && pres.getMedication() != null &&
                    pres.getExpiryDate().isAfter(oneYearAgo)) {
                    System.out.println("  - " + pres.getMedication().getName());
                }
            }
        }
    }

    // Restock medications
    public void restockAllMedications(int amount) {
        for (Medication m : medications) {
            m.restock(amount);
        }
        System.out.println("All medications restocked by " + amount + " units.");
    }

    // Menu Access
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Medication> getMedications() {
        return medications;
    }
}