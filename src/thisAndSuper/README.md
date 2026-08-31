# this and super` in Java

this and super are important keywords in Java, especially when working with **inheritance, constructors, methods, and variables**.

* this → refers to the **current object**
* super → refers to the **immediate parent class**

---

## 1. What is this?

The this keyword refers to the **current object**.

It is mainly used to:

* Access the current object's instance variables
* Call the current class's method
* Call another constructor in the same class
* Pass the current object as an argument

---

## 2. this with Instance Variables

Consider:

```
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Here, there are two `name` variables:

```
this.name
    ↓
Instance variable

name
    ↓
Constructor parameter
```

Therefore:

```
this.name = name;
```

means:

> Assign the constructor parameter `name` to the current object's `name` field.

---

## 3. Why Do We Need this?

Without this, the following can become confusing:

```
class Student {

    String name;

    Student(String name) {
        name = name;
    }
}
```

Both `name` references refer to the constructor parameter.

The instance variable does not get the intended value.

Using this makes the difference clear:

```
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Now:

```
this.name → instance variable
name      → parameter
```

---

## 4. this to Call a Method

this can be used to call a method of the current object.

```
class Student {

    void study() {
        System.out.println("Student is studying");
    }

    void display() {
        this.study();
    }
}
```

This:

```
this.study();
```

calls the `study()` method of the current object.

It can also be written as:

```
study();
```

because Java automatically refers to the current object in this context.

---

## 5. `this()` Constructor Chaining

`this()` is used to call another constructor in the **same class**.

```
class Student {

    String name;
    int age;

    Student() {
        this("Unknown", 0);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Here:

```
Student()
    ↓
this("Unknown", 0)
    ↓
Student(String name, int age)
```

The no-argument constructor calls the parameterized constructor.

---

## 6. Important Rule for `this()`

When `this()` is used inside a constructor, it **must be the first statement**.

### Correct

```
Student() {
    this("Unknown", 0);
}
```

### Incorrect

```
Student() {
    System.out.println("Hello");
    this("Unknown", 0);
}
```

The second version causes a compilation error.

---

# super Keyword

## 7. What is super?

The super keyword refers to the **immediate parent class**.

It is mainly used to:

* Access a parent class variable
* Call a parent class method
* Call a parent class constructor

---

## 8. super with Variables

Consider:

```
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {
        System.out.println(name);
        System.out.println(super.name);
    }
}
```

Output:

```
Dog
Animal
```

Here:

```
name
    ↓
Current class variable

super.name
    ↓
Parent class variable
```

---

## 9. super with Methods

A child class can override a parent method.

```
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

    void display() {
        super.sound();
        sound();
    }
}
```

Output:

```
Animal makes a sound
Dog barks
```

Here:

```
super.sound();
```

calls the **parent class method**.

While:

```
sound();
```

calls the **current class method**.

---

## 10. `super()` Constructor

`super()` is used to call the constructor of the **parent class**.

```
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {
        super();
        System.out.println("Dog constructor");
    }
}
```

When:

```
Dog d = new Dog();
```

the execution is:

```
Dog object creation
       ↓
super()
       ↓
Animal constructor
       ↓
Dog constructor
```

Output:

```
Animal constructor
Dog constructor
```

---

## 11. Important Rule for `super()`

Like `this()`, `super()` must be the **first statement** inside a constructor.

### Correct

```
Dog() {
    super();
    System.out.println("Dog constructor");
}
```

### Incorrect

```
Dog() {
    System.out.println("Dog constructor");
    super();
}
```

The second version causes a compilation error.

---

## 12. this vs super

| this                                                 | super                                    |
| ------------------------------------------------------ | ------------------------------------------ |
| Refers to the current object                           | Refers to the immediate parent class       |
| Accesses current class members                         | Accesses parent class members              |
| `this.name` → current class variable                   | `super.name` → parent class variable       |
| `this.method()` → current class method                 | `super.method()` → parent class method     |
| `this()` → calls another constructor in the same class | `super()` → calls parent class constructor |

---

## 13. this vs `this()`

Do not confuse this with `this()`.

### this

Refers to the **current object**.

```
this.name
this.study()
```

### `this()`

Calls another constructor in the **same class**.

```
this("Suji", 20);
```

Remember:

```
this
 ↓
Current object

this()
 ↓
Another constructor in the same class
```

---

## 14. super vs `super()`

Do not confuse super with `super()`.

### super

Used to access members of the parent class.

```
super.name
super.sound()
```

### `super()`

Calls the constructor of the parent class.

```
super();
```

Remember:

```
super
 ↓
Parent class members

super()
 ↓
Parent class constructor
```

---

## 15. Complete Example

```
class Animal {

    String name = "Animal";

    Animal() {
        System.out.println("Animal constructor");
    }

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    String name = "Dog";

    Dog() {
        super();
        System.out.println("Dog constructor");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void display() {

        System.out.println(this.name);
        System.out.println(super.name);

        this.sound();
        super.sound();
    }
}

public class ThisAndSuperDemo {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.display();
    }
}
```

### Output

```
Animal constructor
Dog constructor
Dog
Animal
Dog barks
Animal makes a sound
```

---

## 16. Execution Flow

When:

```
Dog dog = new Dog();
```

is executed:

```
new Dog()
    ↓
Dog constructor
    ↓
super()
    ↓
Animal constructor
    ↓
Dog constructor continues
    ↓
Dog object is created
```

When:

```
dog.display();
```

is called:

```
this.name
    ↓
Dog's name

super.name
    ↓
Animal's name

this.sound()
    ↓
Dog's sound()

super.sound()
    ↓
Animal's sound()
```

---

## 17. Key Takeaways

```
this
 ↓
Current object
```

```
this()
 ↓
Another constructor in the same class
```

```
super
 ↓
Immediate parent class
```

```
super()
 ↓
Parent class constructor
```

### Most Important Rules

* this refers to the current object.
* super refers to the immediate parent class.
* `this.name` accesses the current class's field.
* `super.name` accesses the parent class's field.
* `this.method()` calls the current class method.
* `super.method()` calls the parent class method.
* `this()` calls another constructor in the same class.
* `super()` calls the parent class constructor.
* `this()` and `super()` must be the first statement in a constructor.
* `this()` and `super()` cannot both be used in the same constructor because only one can be the first statement.

### Simple Definition

> **this refers to the current object, while super refers to the immediate parent class.**
