# JavaSprint1-PharmacySystemT3

## User Documentation

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

Once the application starts you will be greeted with a menu that contains number options, please type the number to the function you wish to complete and press enter.

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

---

## Development Documentation

---

JavaDocs

---

The Source Code Directory Structure of this project in bash is:
Main.Java - This is the entry point of the application
MedicationTrackingSystem.java - This manages all system operations
Person.java - Superclass for both patient and doctor
Patient.java - Patient with medical record
Doctor.java - Doctor
Medication.java - Medications in stock
Prescription.java - Issued prescriptions

---

To Compile this project in the terminal please run the following commands:

cd Pharmcy
javac \*.java

---

this is how a database would look in theory for this project
Entity | Attributes | Relationships
Patient | id, name, age, phoneNumber | has prescriptions
Doctor | id, name, specialization | writes prescriptions
Medication | id, name, quantity, expiryDate | medication for prescription
Prescription | id, patient_id, doctor_id, medication_id, dosage, date links the entites together

in sql this would be the code for the tables.
CREATE TABLE Patients (
id INT PRIMARY KEY,
name VARCHAR(100),
age INT,
phone VARCHAR(20)
);

CREATE TABLE Doctors (
id INT PRIMARY KEY,
name VARCHAR(100),
specialization VARCHAR(100)
);

CREATE TABLE Medications (
id INT PRIMARY KEY,
name VARCHAR(100),
quantity INT,
expiryDate DATE
);

CREATE TABLE Prescriptions (
id INT PRIMARY KEY,
patient_id INT,
doctor_id INT,
medication_id INT,
dosage VARCHAR(50),
dateIssued DATE,
FOREIGN KEY (patient_id) REFERENCES Patients(id),
FOREIGN KEY (doctor_id) REFERENCES Doctors(id),
FOREIGN KEY (medication_id) REFERENCES Medications(id)
);

---

To retrieve the source code for this project in gitbash do the following commands
git clone https://github.com/yourusername/pharmacy-tracking-system.git
( this will clone the repo onto your local machine )
