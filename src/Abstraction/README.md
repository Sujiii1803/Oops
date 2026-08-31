# Abstraction in Java

## What is Abstraction?

**Abstraction** is an OOP principle that hides implementation details and exposes only the essential functionality.

For example, when we start a car, we only need to know that the car can `start()`. We do not need to know the internal mechanism used to start the engine.

In Java, abstraction can be achieved mainly using:

* Abstract classes
* Interfaces

This example demonstrates abstraction using an **abstract class**.

---

## Abstract Class

An abstract class is declared using the `abstract` keyword.

```java
abstract class Vehicle {
    abstract void start();
}
```

An abstract class cannot be directly instantiated.

```java
Vehicle v = new Vehicle(); // ❌ Not allowed
```

A child class must provide an implementation for the abstract methods.

---

## Example

The example contains:

* `Vehicle` → Abstract parent class
* `Car` → Child class
* `Bike` → Child class
* `Main` → Main class

### Class Structure

```text
                Vehicle
              (abstract)
                  |
          -----------------
          |               |
         Car             Bike
```

`Vehicle` defines the common behavior, while `Car` and `Bike` provide their own implementation of `start()`.

---

## Important Parts

### 1. Abstract Method

```java
abstract void start();
```

An abstract method has no implementation in the parent class.

The child class must implement it.

```java
@Override
void start() {
    System.out.println("Car starts using a key");
}
```

---

### 2. Concrete Method

An abstract class can also contain normal methods.

```java
void stop() {
    System.out.println(brand + " is stopped");
}
```

This method already has an implementation, so child classes can directly use it.

---

### 3. Constructor in Abstract Class

An abstract class can have a constructor.

```java
Vehicle(String brand) {
    this.brand = brand;
}
```

The constructor is called when a child-class object is created through `super()`.

```java
Car(String brand) {
    super(brand);
}
```

---

### 4. Parent Reference and Child Object

```java
Vehicle car = new Car("Toyota");
```

Here:

* `Vehicle` → reference type
* `Car` → actual object

The same applies to:

```java
Vehicle bike = new Bike("Yamaha");
```

This also demonstrates **runtime polymorphism**.

When:

```java
car.start();
```

Java executes the `start()` method of `Car`.

When:

```java
bike.start();
```

Java executes the `start()` method of `Bike`.

---

## Why Use Abstraction?

Abstraction helps us:

1. Hide implementation details
2. Define common behavior
3. Force child classes to implement required methods
4. Reduce unnecessary complexity
5. Make code easier to maintain
6. Support polymorphism

---

## Abstraction vs Encapsulation

| Abstraction                                    | Encapsulation                                           |
| ---------------------------------------------- | ------------------------------------------------------- |
| Hides implementation details                   | Protects data                                           |
| Focuses on what an object does                 | Focuses on how data is accessed                         |
| Achieved using abstract classes and interfaces | Achieved using access modifiers, getters, setters, etc. |
| Example: `start()`                             | Example: `private balance`                              |

### Simple way to remember

**Abstraction → What should be exposed?**

**Encapsulation → How should data be protected?**

---

## Key Points

* An abstract class uses the `abstract` keyword.
* We cannot create an object directly from an abstract class.
* An abstract class can have abstract methods.
* An abstract class can also have normal/concrete methods.
* An abstract class can have constructors and instance variables.
* Child classes use `extends` to inherit from an abstract class.
* Child classes must implement inherited abstract methods.
* Abstraction can also be achieved using interfaces.
* Parent references can point to child objects, enabling runtime polymorphism.

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)

---

## How to Run

Save the file as:

```text
Main.java
```

Compile:

```bash
javac Main.java
```

Run:

```bash
java Main
```

---

## Expected Output

```text
---- Car ----
Brand: Toyota
Toyota starts using a key
Toyota is stopped

---- Bike ----
Brand: Yamaha
Yamaha starts using a self-start button
Yamaha is stopped
```

---

## OOP Concepts Demonstrated

This example demonstrates:

* Abstraction
* Abstract class
* Abstract method
* Concrete method
* Constructor
* Inheritance
* Method overriding
* `super`
* Runtime polymorphism
* Parent reference and child object
