package Inheritance;

// Demonstration of Inheritance in Java
class Animal {

    protected String name;

    // Parent constructor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    // Parent method
    void eat() {
        System.out.println(name + " is eating");
    }

    // Method that can be overridden
    void sound() {
        System.out.println("Animal makes a sound");
    }
}


// Dog inherits from Animal
class Dog extends Animal {

    // Child constructor
    Dog(String name) {
        super(name); // Calls parent constructor
        System.out.println("Dog constructor called");
    }

    // Child-specific method
    void bark() {
        System.out.println(name + " is barking");
    }

    // Method overriding
//   @Override
//    void sound() {
//        System.out.println(name + " says Woof!");
//    }
}

// Main class
public class InheritanceDemo {

    public static void main(String[] args) {

        // Creating Dog object
        Dog dog = new Dog("Tommy");

        System.out.println();

        // Inherited method
        dog.eat();

        // Overridden method
        dog.sound();

        // Child-specific method
        dog.bark();
    }
}