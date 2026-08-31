# Class and Object

## 1. What is a Class?

A **class** is a blueprint or template used to create objects.

A class defines:

* **Data** → Fields / Variables
* **Behavior** → Methods
* **Initialization** → Constructors

### Example

```
class Student {

    String name;
    int age;

    void study() {
        System.out.println(name + " is studying");
    }
}
```

The `Student` class contains:

```
Student
├── name
├── age
└── study()
```

Here, `Student` is the **class**.

---

## 2. What is an Object?

An **object** is an instance of a class.

Objects are created using the `new` keyword.

```
Student s1 = new Student();
```

Here:

```
Student       → Class
s1            → Reference variable
new Student() → Object
```

The object contains its own **state** and can use the **behavior** defined by the class.

---

## 3. Class vs Object

| Class                                    | Object                         |
| ---------------------------------------- | ------------------------------ |
| Blueprint / template                     | Actual instance                |
| Logical definition                       | Runtime entity                 |
| Defines fields and methods               | Contains actual values         |
| Does not represent one specific instance | Represents a specific instance |

### Example

```
class Student {
    String name;
    int age;
}
```

The class defines the structure.

```
Student s1 = new Student();
Student s2 = new Student();
```

These statements create two different objects.

---

## 4. Creating Multiple Objects

```
class Student {

    String name;
    int age;
}

public class ClassAndObjectDemo {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Suji";
        s1.age = 20;

        s2.name = "Arun";
        s2.age = 21;

        System.out.println(s1.name);
        System.out.println(s1.age);

        System.out.println(s2.name);
        System.out.println(s2.age);
    }
}
```

### Object State

Each object has its own copy of **instance fields**.

```
s1
├── name = "Suji"
└── age  = 20

s2
├── name = "Arun"
└── age  = 21
```

Therefore:

```
s1.age → 20
s2.age → 21
```

Changing `s1.age` does not change `s2.age`.

---

## 5. Reference Variable vs Object

This is an important distinction.

```
Student s1 = new Student();
```

There are three things to understand:

```
Student s1 = new Student();
   │      │       │
   │      │       └── Object
   │      └────────── Reference variable
   └───────────────── Class
```

### `new Student()`

Creates a new `Student` object.

### `s1`

Stores a **reference** to that object.

### `Student`

Specifies the type of the reference variable.

---

## 6. Instance Variables

A variable declared inside a class but outside methods is an **instance variable** when it is non-static.

```
class Student {

    String name;
    int age;
}
```

Every object gets its own instance fields.

```
Student s1 = new Student();
Student s2 = new Student();

s1.age = 20;
s2.age = 25;
```

Now:

```
s1.age → 20
s2.age → 25
```

The values are independent because they belong to different objects.

---

## 7. Instance Methods

An **instance method** is a method that can operate on the state of an object.

```
class Student {

    String name;

    void introduce() {
        System.out.println("My name is " + name);
    }
}
```

### Usage

```
Student s1 = new Student();

s1.name = "Suji";
s1.introduce();
```

### Output

```
My name is Suji
```

The method operates on the state of the object that calls it.

---

## 8. How Object Creation Works

When this statement executes:

```
Student s1 = new Student();
```

Conceptually, the process is:

```
1. new Student()
       ↓
2. Memory is allocated for the object
       ↓
3. Instance fields receive default values
       ↓
4. Constructor executes
       ↓
5. Reference to the object is returned
       ↓
6. s1 stores that reference
```

> **Note:** This is a conceptual model of object creation. The JVM specification does not require every implementation detail to occur in exactly this observable sequence.

---

## 9. Default Values of Instance Variables

If instance variables are not explicitly initialized, Java assigns them default values.

```
class Student {

    int age;
    double marks;
    String name;
    boolean passed;
    char grade;
}
```

### Default Values

| Data Type       | Default Value |
| --------------- | ------------- |
| `int`           | `0`           |
| `double`        | `0.0`         |
| `boolean`       | `false`       |
| `char`          | `'\u0000'`    |
| Reference types | `null`        |

> **Important:** These default values apply to **instance variables** and other class-level fields, not to local variables.

---

## 10. Class as a Blueprint

A class defines what an object should contain and what it can do.

```
class Car {

    String brand;
    int speed;

    void accelerate() {
        speed += 10;
    }
}
```

The class defines:

```
State:
    brand
    speed

Behavior:
    accelerate()
```

An object is a concrete instance of this definition.

### Example

```
Car car1 = new Car();

car1.brand = "BMW";
car1.speed = 50;

car1.accelerate();
```

After calling `accelerate()`:

```
speed = 60
```

---

## 11. Important Terms

### Class

A blueprint or template used to create objects.

### Object

An instance of a class.

### Field

A variable declared inside a class.

### Instance Variable

A non-static field that belongs to an individual object.

### Method

A block of code that defines behavior.

### Instance

An individual object created from a class.

### Reference Variable

A variable that stores a reference to an object.

---

## 12. Complete Example

```
class Student {

    String name;
    int age;

    void introduce() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void study() {
        System.out.println(name + " is studying");
    }
}

public class ClassAndObjectDemo {

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Suji";
        s1.age = 20;

        s1.introduce();
        s1.study();
    }
}
```

### Output

```
Name: Suji
Age: 20
Suji is studying
```

---

## 13. Key Takeaway

```
             CLASS
               ↓
        Blueprint / Template
               ↓
        Creates Objects
               ↓
            OBJECT
          ↙        ↘
       State      Behavior
      (Fields)    (Methods)
```

### Simple Definition

> **A class defines the structure and behavior, while an object is an actual instance of that class.**

### Remember

```
Class  → Blueprint
Object → Instance
Field  → State
Method → Behavior
new    → Creates an object
```
