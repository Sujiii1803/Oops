# Polymorphism in Java

Polymorphism is one of the **four major pillars of Object-Oriented Programming (OOP)**.

The four pillars are:

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

The word **polymorphism** comes from:

* **Poly** → Many
* **Morphism** → Forms

Therefore, polymorphism means **one thing having many forms**.

---

## 1. What is Polymorphism?

Polymorphism allows the **same method call** to produce **different behavior** depending on the object.

```text
Animal
   |
   |--- Dog → sound() → Bark
   |
   |--- Cat → sound() → Meow
   |
   |--- Cow → sound() → Moo
```

The method name is the same:

```text
sound();
```

But each child class provides its own implementation.

---

## 2. Types of Polymorphism

Java mainly supports two types of polymorphism:

```text
                    Polymorphism
                         |
             +-----------+-----------+
             |                       |
      Compile-time              Runtime
      Polymorphism             Polymorphism
             |                       |
      Method Overloading       Method Overriding
```

| Type                      | Achieved Using     | Decision Time |
| ------------------------- | ------------------ | ------------- |
| Compile-time polymorphism | Method Overloading | Compile Time  |
| Runtime polymorphism      | Method Overriding  | Runtime       |

---

## 3. Compile-Time Polymorphism

Compile-time polymorphism is achieved through **method overloading**.

Method overloading means having multiple methods with the **same name but different parameters**.

### Example

```text
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

Here:

```text
add(int, int)
add(int, int, int)
add(double, double)
```

have the same method name but different parameter lists.

The compiler determines which method should be called.

Therefore, it is called **compile-time polymorphism**.

---

## 4. Runtime Polymorphism

Runtime polymorphism is achieved through:

* Inheritance
* Method Overriding
* Parent reference pointing to a child object

### Example

```text
class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

Now:

```text
Animal animal;

animal = new Dog();
animal.sound();

animal = new Cat();
animal.sound();
```

### Output

```text
Dog barks
Cat meows
```

The reference variable is always:

```text
Animal animal;
```

But it points to different objects:

```text
Animal animal = new Dog();

Reference Type → Animal
Actual Object  → Dog
```

Then:

```text
Animal animal = new Cat();

Reference Type → Animal
Actual Object  → Cat
```

The method that executes depends on the **actual object**.

---

## 5. Parent Reference and Child Object

One of the most important patterns in runtime polymorphism is:

```text
Parent reference = new Child();
```

For example:

```text
Animal animal = new Dog();
```

Here:

```text
Reference Type → Animal
Actual Object  → Dog
```

When we call:

```text
animal.sound();
```

Java executes the overridden method of `Dog`.

This is known as **dynamic method dispatch**.

---

## 6. Dynamic Method Dispatch

Dynamic method dispatch is the mechanism by which Java determines **at runtime** which overridden method should be executed.

### Example

```text
Animal animal;

animal = new Dog();
animal.sound();
```

Execution:

```text
animal
  |
  ↓
Dog object
  |
  ↓
Dog.sound()
```

If the object changes:

```text
animal = new Cat();
animal.sound();
```

Execution becomes:

```text
animal
  |
  ↓
Cat object
  |
  ↓
Cat.sound()
```

Therefore:

```text
Same reference
      ↓
Different objects
      ↓
Same method call
      ↓
Different behavior
```

---

## 7. Important Rule

Remember this:

> **Reference type determines what members are accessible, while the actual object determines which overridden instance method executes.**

### Example

```text
Animal animal = new Dog();

animal.sound();
```

* `Animal` → Reference type
* `Dog` → Actual object
* `sound()` → Overridden method
* `Dog.sound()` → Executed at runtime

---

## 8. Method Overloading vs Method Overriding

| Feature              | Overloading        | Overriding                |
| -------------------- | ------------------ | ------------------------- |
| Polymorphism         | Compile-time       | Runtime                   |
| Relationship         | Usually same class | Parent-child relationship |
| Method name          | Same               | Same                      |
| Parameters           | Must be different  | Same                      |
| Inheritance required | No                 | Yes                       |
| Decision             | Compile time       | Runtime                   |

### Overloading

```text
class Calculator {

    void add(int a, int b) {
    }

    void add(int a, int b, int c) {
    }
}
```

### Overriding

```text
class Animal {

    void sound() {
    }
}

class Dog extends Animal {

    @Override
    void sound() {
    }
}
```

---

## 9. Fields Are Not Polymorphic

Instance variables are not overridden like methods.

### Example

```text
class Parent {

    int value = 10;
}

class Child extends Parent {

    int value = 20;
}
```

Now:

```text
Parent obj = new Child();

System.out.println(obj.value);
```

### Output

```text
10
```

Fields are **hidden**, not overridden.

Methods behave differently:

```text
class Parent {

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child");
    }
}
```

```text
Parent obj = new Child();

obj.show();
```

### Output

```text
Child
```

Therefore:

> **Instance methods participate in runtime polymorphism; fields do not.**

---

## 10. Static Methods and Polymorphism

Static methods are also **not overridden**.

They are hidden.

### Example

```text
class Parent {

    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    static void show() {
        System.out.println("Child");
    }
}
```

```text
Parent obj = new Child();

obj.show();
```

### Output

```text
Parent
```

Static method selection is based on the **reference type**, not the actual object.

---

## 11. Practical Example

Consider a payment system:

```text
Payment
   |
   |--- UPIPayment
   |--- CreditCardPayment
   |--- CashPayment
```

### Parent Class

```text
class Payment {

    void pay() {
        System.out.println("Payment");
    }
}
```

### Child Classes

```text
class UPIPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Pay using UPI");
    }
}
```

```text
class CreditCardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Pay using Credit Card");
    }
}
```

```text
class CashPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Pay using Cash");
    }
}
```

### Using Polymorphism

```text
public class Main {

    public static void main(String[] args) {

        Payment payment;

        payment = new UPIPayment();
        payment.pay();

        payment = new CreditCardPayment();
        payment.pay();

        payment = new CashPayment();
        payment.pay();
    }
}
```

### Output

```text
Pay using UPI
Pay using Credit Card
Pay using Cash
```

The same reference:

```text
Payment payment;
```

is used for different child objects.

---

## 12. Why Do We Need Polymorphism?

Polymorphism makes code more:

* Flexible
* Maintainable
* Extensible
* Reusable

Instead of writing code specifically for every child class, we can work with the common parent type.

For example:

```text
Payment payment;
```

can represent:

```text
UPIPayment
CreditCardPayment
CashPayment
```

This becomes especially useful when applications contain many related classes.

---

## 13. Key Points to Remember

### Compile-Time Polymorphism

```text
Method Overloading
        ↓
Same method name
        ↓
Different parameters
        ↓
Compiler decides
```

### Runtime Polymorphism

```text
Inheritance
     ↓
Method Overriding
     ↓
Parent Reference
     ↓
Child Object
     ↓
Dynamic Method Dispatch
     ↓
Runtime decides which overridden method executes
```

### Most Important Pattern

```text
Parent reference = new Child();
reference.method();
```

Example:

```text
Payment payment = new UPIPayment();
payment.pay();
```

Here:

```text
Payment       → Reference type
UPIPayment    → Actual object
pay()         → Overridden method
```

---

## 14. Simple Definition

> **Polymorphism is the ability of a single reference or interface to represent different objects and produce different behavior depending on the actual object.**

### Easy Way to Remember

> **Same method call → Different behavior depending on the actual object.**

---

## 15. Interview Summary

### Q: What is polymorphism?

Polymorphism is an OOP concept where the same interface or method call can have different behavior.

### Q: What are the types of polymorphism in Java?

1. Compile-time polymorphism
2. Runtime polymorphism

### Q: How is compile-time polymorphism achieved?

Through **method overloading**.

### Q: How is runtime polymorphism achieved?

Through **method overriding and dynamic method dispatch**.

### Q: What is the important runtime polymorphism pattern?

```text
Parent reference = new Child();
```

### Q: Which method executes in runtime polymorphism?

The overridden method belonging to the **actual object** executes.

### Q: Are fields overridden?

No. Fields are hidden, not overridden.

### Q: Are static methods overridden?

No. Static methods are hidden, not overridden.

---

## 16. Final Mental Model

```text
                 POLYMORPHISM
                      |
          +-----------+-----------+
          |                       |
     Compile Time             Runtime
          |                       |
    Method Overloading      Method Overriding
                                  |
                           Parent Reference
                                  |
                             Child Object
                                  |
                         Dynamic Method Dispatch
                                  |
                         Different Behavior
```

### Core Idea

```text
Parent reference = new Child();
reference.method();
```

**Same reference + different child objects + overridden method = Runtime Polymorphism**
