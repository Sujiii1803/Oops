# Constructor

## 1. What is a Constructor?

A **constructor** is a special member of a class that is automatically executed when an object is created.

Its main purpose is to **initialize the object**.

### Example

```
class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }
}
```

When we create an object:

```
Student s1 = new Student();
```

The constructor:

```
Student()
```

is automatically called.

---

## 2. Why Do We Need Constructors?

Without a constructor:

```
Student s1 = new Student();

s1.name = "Suji";
s1.age = 20;
```

We create the object first and initialize its fields separately.

A constructor allows us to initialize the object at the time of creation.

```
Student s1 = new Student("Suji", 20);
```

---

## 3. Constructor Rules

A constructor:

1. Must have the same name as the class.
2. Does not have a return type.
3. Is automatically called when an object is created.
4. Can accept parameters.
5. Can be overloaded.
6. Is used to initialize object state.

### Example

```
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Notice:

```
Student(String name)
```

has no return type.

This is a constructor.

---

## 4. Constructor vs Method

| Constructor                                 | Method                      |
| ------------------------------------------- | --------------------------- |
| Same name as class                          | Can have any valid name     |
| No return type                              | Has a return type or `void` |
| Called automatically during object creation | Usually called explicitly   |
| Initializes object                          | Performs an operation       |
| Cannot be inherited                         | Methods can be inherited    |

### Example

```
class Student {

    Student() {
        // Constructor
    }

    void study() {
        // Method
    }
}
```

---

## 5. No-Argument Constructor

A constructor without parameters is called a **no-argument constructor**.

```
class Student {

    String name;

    Student() {
        name = "Unknown";
    }
}
```

### Usage

```
Student s1 = new Student();
```

---

## 6. Parameterized Constructor

A constructor that accepts parameters is called a **parameterized constructor**.

```
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

### Usage

```
Student s1 = new Student("Suji", 20);
Student s2 = new Student("Arun", 21);
```

Now each object can be initialized with different values.

---

## 7. The `this` Keyword in Constructors

Consider:

```
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

There are two `name` variables:

```
this.name
    ↓
instance variable

name
    ↓
constructor parameter
```

Therefore:

```
this.name = name;
```

means:

> Assign the constructor parameter `name` to the current object's `name` field.

---

## 8. Constructor Overloading

A class can have multiple constructors as long as their parameter lists are different.

```
class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String name) {
        this.name = name;
        age = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

This is called **constructor overloading**.

### Usage

```
Student s1 = new Student();

Student s2 = new Student("Suji");

Student s3 = new Student("Suji", 20);
```

Java selects the appropriate constructor based on the arguments.

---

## 9. Default Constructor

This is an important distinction.

If you do **not write any constructor**, Java provides a constructor automatically.

### Example

```
class Student {

    String name;
}
```

Conceptually, Java provides:

```
Student() {
    // default initialization
}
```

So this works:

```
Student s1 = new Student();
```

---

## 10. Important Rule About the Default Constructor

If you write **any constructor yourself**, Java does not automatically provide the no-argument constructor.

### Example

```
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Now this will **NOT compile**:

```
Student s1 = new Student();
```

because there is no no-argument constructor.

But this works:

```
Student s1 = new Student("Suji");
```

If you want both, define both explicitly:

```
Student() {
}

Student(String name) {
    this.name = name;
}
```

---

## 11. Constructor Chaining Using `this()`

One constructor can call another constructor in the same class using:

```
this();
```

### Example

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
```

calls:

```
Student(String name, int age)
```

using:

```
this("Unknown", 0);
```

---

## 12. Important Rule for `this()`

If you use `this()` inside a constructor, it must be the **first statement**.

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

## 13. Constructor Execution During Object Creation

Consider:

```
class Student {

    Student() {
        System.out.println("Constructor called");
    }
}

public class ConstructorDemo {

    public static void main(String[] args) {

        System.out.println("Before object");

        Student s1 = new Student();

        System.out.println("After object");
    }
}
```

### Execution Order

```
main() starts
     ↓
"Before object"
     ↓
new Student()
     ↓
Student constructor executes
     ↓
"Constructor called"
     ↓
object creation completes
     ↓
"After object"
```

### Output

```
Before object
Constructor called
After object
```

---

## 14. Constructor and Object Initialization

A constructor is especially useful when an object must start with a valid state.

### Example

```
class BankAccount {

    private double balance;

    BankAccount(double balance) {

        if (balance >= 0) {
            this.balance = balance;
        }
    }
}
```

Now:

```
BankAccount account = new BankAccount(10000);
```

The object starts with its initial balance.

---

## 15. Constructors and `static`

A constructor belongs to the process of creating an **object**.

Therefore, a constructor cannot be declared `static`.

### Invalid

```
static Student() {
}
```

Constructors are associated with object initialization, while `static` members belong to the class rather than an individual object.

---

## 16. Constructors Cannot Have a Return Type

This is incorrect:

```
class Student {

    void Student() {
    }
}
```

This is actually a **method**, not a constructor.

Why?

Because it has:

```
void
```

A constructor has no return type:

```
Student() {
}
```

---

## 17. Constructor and Inheritance

Constructors are **not inherited** by subclasses.

However, when a subclass object is created, a constructor from the parent class is involved in initializing the parent portion of the object.

### Example

```
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {
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
Animal constructor
       ↓
Dog constructor
```

### Output

```
Animal constructor
Dog constructor
```

---

## 18. Constructor vs `this`

Do not confuse:

```
this
```

with:

```
this()
```

### `this`

Refers to the current object.

```
this.name = name;
```

### `this()`

Calls another constructor in the same class.

```
this("Unknown");
```

So:

```
this
 ↓
current object

this()
 ↓
another constructor in same class
```

---

## 19. Constructor vs `super()`

Similarly, don't confuse:

```
this()
```

and:

```
super()
```

### `this()`

Calls another constructor in the **same class**.

### `super()`

Calls a constructor of the **parent class**.

### Example

```
class Animal {

    Animal() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    Dog() {
        super();
        System.out.println("Dog");
    }
}
```

---

## 20. Key Takeaways

Remember these points:

```
Constructor
    ↓
Special member of a class
    ↓
Same name as class
    ↓
No return type
    ↓
Called during object creation
    ↓
Used mainly for initialization
```

### Most Important Rules

* Constructor name = class name
* No return type
* Automatically invoked when an object is created
* Can be overloaded
* Can accept parameters
* `this()` calls another constructor in the same class
* `super()` calls a parent constructor
* `this()` must be the first statement
* Constructors are not inherited
* If no constructor is written, Java provides a default constructor
* Once you define a constructor, Java does not automatically provide the no-argument constructor

### Interview Definition

> **A constructor is a special member of a Java class that has the same name as the class and no return type. It is invoked when an object is created and is primarily used to initialize the object's state.**
