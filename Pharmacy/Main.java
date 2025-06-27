package Pharmacy;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n===== Welcome To The Pharmacy Med Tracking System =====");
            System.out.println("What would you like to do?");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication To The Pharmacy");
            System.out.println("4: Print System Report");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Process A New Prescription");
            System.out.println("7: Print All Prescriptions For Specific Doctor");
            System.out.println("8: Restock the Drugs in the Pharmacy");
            System.out.println("9: Print All Prescriptions for Specific Patient");
            System.out.println("10: Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addANewPatient(scanner, system);
                    break;
                case 2:
                    addANewDoctor(scanner, system);
                    break;
                case 3:
                    addNewMedicationToPharmacy(scanner, system);
                    break;
                case 4:
                    printPharmacyReport(system);
                    break;
                case 5:
                    checkExpiredMeds(system);
                    break;
                case 6:
                    processANewScript(scanner, system);
                    break;
                case 7:
                    printScriptsForSpecificDoctor(scanner, system);
                    break;
                case 8:
                    restockPharmacyDrugs(scanner, system);
                    break;
                case 9:
                    printAllScriptsForPatientByName(scanner, system);
                    break;
                case 10:
                    exit = true;
                    System.out.println("Exiting The System! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    // === Menu Methods ===

    private static void addANewPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter ID, Name, Age, Phone: ");
        int id = scanner.nextInt(); scanner.nextLine();
        String name = scanner.nextLine();
        int age = scanner.nextInt(); scanner.nextLine();
        String phone = scanner.nextLine();
        system.addPatient(new Patient(id, name, age, phone));
        System.out.println("Patient added.");
    }

    private static void addANewDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter ID, Name, Age, Phone, Specialization: ");
        int id = scanner.nextInt(); scanner.nextLine();
        String name = scanner.nextLine();
        int age = scanner.nextInt(); scanner.nextLine();
        String phone = scanner.nextLine();
        String specialization = scanner.nextLine();
        system.addDoctor(new Doctor(id, name, age, phone, specialization));
        System.out.println("Doctor added.");
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter ID, Name, Dose, Quantity, Expiry (YYYY-MM-DD): ");
        int id = scanner.nextInt(); scanner.nextLine();
        String name = scanner.nextLine();
        String dose = scanner.nextLine();
        int qty = scanner.nextInt(); scanner.nextLine();
        LocalDate expiry = LocalDate.parse(scanner.nextLine());
        system.addMedication(new Medication(id, name, dose, qty, expiry));
        System.out.println("Medication added.");
    }

    private static void printPharmacyReport(MedicationTrackingSystem system) {
        System.out.println("--- System Report ---");
        system.generateSystemReport();
    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
        System.out.println("--- Expired Medications ---");
        system.generateExpiredMedicationsReport();
    }

    private static void processANewScript(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Prescription ID, Doctor ID, Patient ID, Medication ID: ");
        int pid = scanner.nextInt();
        int docId = scanner.nextInt();
        int patId = scanner.nextInt();
        int medId = scanner.nextInt();
        scanner.nextLine();

        Doctor doc = system.getDoctors().stream().filter(d -> d.getId() == docId).findFirst().orElse(null);
        Patient pat = system.getPatients().stream().filter(p -> p.getId() == patId).findFirst().orElse(null);
        Medication med = system.getMedications().stream().filter(m -> m.getId() == medId).findFirst().orElse(null);

        if (doc != null && pat != null && med != null) {
            Prescription pres = new Prescription(pid, doc, pat, med, LocalDate.now());
            system.addPrescription(pres);
            System.out.println("Prescription added.");
        } else {
            System.out.println("Invalid doctor, patient, or medication ID.");
        }
    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        int docId = scanner.nextInt();
        system.printPrescriptionsByDoctor(docId);
    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter restock amount for each drug: ");
        int amount = scanner.nextInt();
        system.restockAllMedications(amount);
    }

    private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        for (Patient p : system.getPatients()) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Prescriptions for " + name + ":");
                for (Prescription pres : p.getPrescriptions()) {
                    pres.displayInfo();
                }
                return;
            }
        }

        System.out.println("Patient not found.");
    }
}