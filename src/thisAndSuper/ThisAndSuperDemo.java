package thisAndSuper;

class Animal {

    String name = "Animal";

    // Parent constructor
    Animal() {
        System.out.println("Animal constructor");
    }

    // Parent method
    void sound() {
        System.out.println("Animal makes a sound");
    }
}


class Dog extends Animal {

    String name = "Dog";

    // Child constructor
    Dog() {
        super();   // Calls Animal constructor
        System.out.println("Dog constructor");
    }

    // Overriding parent method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void display() {

        // this → current class
        System.out.println("this.name  : " + this.name);

        // super → parent class
        System.out.println("super.name : " + super.name);

        // Calls child class method
        System.out.println("\nCalling this.sound():");
        this.sound();

        // Calls parent class method
        System.out.println("\nCalling super.sound():");
        super.sound();
    }
}


public class ThisAndSuperDemo {

    public static void main(String[] args) {

        // Creating Dog object
        Dog dog = new Dog();

        System.out.println();

        // Demonstrating this and super
        dog.display();
    }
}
