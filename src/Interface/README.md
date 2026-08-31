# Interface in Java

## What is an Interface?

An **interface** in Java is a blueprint or contract that defines the behavior a class should provide.

It is mainly used to achieve:

* Abstraction
* Multiple inheritance
* Polymorphism
* Loose coupling

An interface is declared using the `interface` keyword.

```java
interface Payment {
    void pay();
}
```

A class implements an interface using the `implements` keyword.

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made using UPI");
    }
}
```

---

## Example

This example uses a **Payment** interface.

Different payment methods implement the same interface:

```text
                    Payment
                   Interface
                       |
              -------------------
              |                 |
        UpiPayment        CardPayment
```

Both classes must provide their own implementation of the `pay()` method.

---

## 1. Creating an Interface

```java
interface Payment {

    void pay();
}
```

The `pay()` method does not have an implementation.

It defines a rule:

> Any class implementing `Payment` must provide the `pay()` method.

---

## 2. Implementing an Interface

A class uses `implements` to implement an interface.

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made using UPI");
    }
}
```

Since `UpiPayment` implements `Payment`, it must implement the `pay()` method.

---

## 3. Multiple Classes Implementing One Interface

More than one class can implement the same interface.

```java
class UpiPayment implements Payment {

    public void pay() {
        System.out.println("Payment made using UPI");
    }
}
```

```java
class CardPayment implements Payment {

    public void pay() {
        System.out.println("Payment made using Credit Card");
    }
}
```

Both classes follow the same contract but provide different implementations.

---

## 4. Interface Reference

An interface reference can point to an object of a class that implements the interface.

```java
Payment payment = new UpiPayment();

payment.pay();
```

Here:

* `Payment` → reference type
* `UpiPayment` → actual object

Java executes the `pay()` method of `UpiPayment`.

This is also an example of **runtime polymorphism**.

---

## 5. Default Method

An interface can contain a `default` method with an implementation.

```java
interface Payment {

    void pay();

    default void paymentStatus() {
        System.out.println("Payment processing...");
    }
}
```

The implementing class can directly use the default method.

```java
payment.paymentStatus();
```

It can also override the default method if required.

---

## 6. Multiple Inheritance Through Interfaces

Java does **not** support multiple inheritance using classes.

```java
class Child extends Parent1, Parent2 {
    // ❌ Not allowed
}
```

But Java supports multiple inheritance through interfaces.

```java
interface Camera {
    void takePhoto();
}

interface GPS {
    void getLocation();
}

class Smartphone implements Camera, GPS {

    public void takePhoto() {
        System.out.println("Taking photo");
    }

    public void getLocation() {
        System.out.println("Getting location");
    }
}
```

Here, `Smartphone` implements both `Camera` and `GPS`.

```text
       Camera          GPS
          \             /
           \           /
            Smartphone
```

This is called **multiple inheritance through interfaces**.

---

## 7. Interface Variables

Variables declared inside an interface are implicitly:

```java
public static final
```

Example:

```java
interface Payment {

    int MAX_AMOUNT = 100000;
}
```

This is equivalent to:

```java
public static final int MAX_AMOUNT = 100000;
```

Therefore, the value cannot be changed.

```java
Payment.MAX_AMOUNT = 50000; // ❌ Not allowed
```

---

## 8. Interface vs Abstract Class

| Interface                                      | Abstract Class                                   |
| ---------------------------------------------- | ------------------------------------------------ |
| Declared using `interface`                     | Declared using `abstract class`                  |
| Class uses `implements`                        | Class uses `extends`                             |
| Supports multiple inheritance                  | Does not support multiple class inheritance      |
| Cannot have a constructor                      | Can have a constructor                           |
| Mainly defines a contract                      | Provides a common base and shared implementation |
| Variables are implicitly `public static final` | Can have instance variables                      |
| Supports abstract methods                      | Supports abstract methods                        |
| Supports `default` and `static` methods        | Supports normal and abstract methods             |

---

## 9. Interface vs Inheritance

Consider:

```java
class Dog extends Animal
```

This represents an **IS-A** relationship.

```text
Dog IS-A Animal
```

But:

```java
class Bird implements Flyable
```

represents a **capability**.

```text
Bird CAN Fly
```

The same `Flyable` interface could be implemented by:

```text
Bird
Airplane
Drone
```

These classes do not need to belong to the same inheritance hierarchy.

---

## 10. Advantages of Interfaces

### Abstraction

Interfaces hide implementation details and expose required behavior.

### Multiple Inheritance

A class can implement multiple interfaces.

### Loose Coupling

Code can depend on an interface rather than a specific implementation.

### Polymorphism

The same interface reference can refer to different implementations.

Example:

```java
Payment p;

p = new UpiPayment();
p.pay();

p = new CardPayment();
p.pay();
```

The reference type remains `Payment`, while the actual implementation changes.

---

## Key Points

* An interface is a contract for classes.
* It is declared using the `interface` keyword.
* Classes implement interfaces using `implements`.
* A class can implement multiple interfaces.
* An interface cannot be instantiated directly.
* Interfaces are commonly used to achieve abstraction.
* Interfaces support multiple inheritance.
* Interfaces can contain abstract methods.
* Interfaces can contain `default` and `static` methods.
* Interface variables are implicitly `public static final`.
* Interface references support runtime polymorphism.

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)

---

## How to Run

Compile the Java file:

```bash
javac Main.java
```

Run the program:

```bash
java Main
```

---

## OOP Concepts Demonstrated

* Interface
* Abstraction
* `implements`
* Abstract methods
* Default methods
* Method overriding
* Multiple interface implementation
* Multiple inheritance
* Runtime polymorphism
* Interface reference
* Loose coupling
