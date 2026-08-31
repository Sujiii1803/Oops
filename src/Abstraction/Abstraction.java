package Abstraction;

// Abstract class
abstract class Vehicle {

    String brand;

    // Constructor
    Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method
    // Child classes must provide the implementation
    abstract void start();

    // Concrete method
    // Common implementation for all vehicles
    void stop() {
        System.out.println(brand + " is stopped");
    }

    void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

// Child class
class Car extends Vehicle {

    Car(String brand) {
        super(brand);
    }

    // Providing implementation for abstract method
    @Override
    void start() {
        System.out.println(brand + " starts using a key");
    }
}

// Another child class
class Bike extends Vehicle {

    Bike(String brand) {
        super(brand);
    }

    // Providing implementation for abstract method
    @Override
    void start() {
        System.out.println(brand + " starts using a self-start button");
    }
}

// Main class
public class Abstraction {

    public static void main(String[] args) {

        // Parent reference pointing to child objects
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Yamaha");

        System.out.println("---- Car ----");
        car.displayBrand();
        car.start();
        car.stop();

        System.out.println();

        System.out.println("---- Bike ----");
        bike.displayBrand();
        bike.start();
        bike.stop();
    }
}

