// Superclass

package Pharmacy;

public class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber);
    }
}