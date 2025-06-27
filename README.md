# JavaSprint1-PharmacySystemT3

---

This is a Pharmacy Medicatin Tracking System that stores the following:

- Patient records
- Doctor records
- Medications
- Prescriptions
- Expiry and Restocking Medications

---

To run this program in terminal you will need to enter the following commands in order:
cd Pharmacy
javac \* .java
java Main

---

Descriptions of the classes included

Person: This is the superclass, it includes both Patient and Doctor and contains the following information: id, name, age, phonenumber.

Patient: This class inherits from the Person class, it lists the prescriptions for the patient.

Doctor: This class inherits from the Person class, it adds a specialization to the doctor and a list of prescriptions.

Medication: This class holds the medications id, name, dose, quantity and the expiry date.

Prescription: This class links both Doctor, Patient and the Medication class.

MedicationTrackingSystem: The MedicationTrackingSystem manages all patients, doctors, medications and prescriptions. This System allows us to do the following:

- add
- search
- edit
- report
- restock

Main: Contains the menu and scanner.
