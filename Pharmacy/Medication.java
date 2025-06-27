package Pharmacy;

import java.time.LocalDate;

public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public void restock(int amount) {
        quantityInStock += amount;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public void displayInfo() {
        System.out.println("Medication ID: " + id + ", Name: " + name + ", Dose: " + dose +
                ", Stock: " + quantityInStock + ", Expiry: " + expiryDate);
    }
}