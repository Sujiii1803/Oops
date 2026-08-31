package Constructor;
class Patient {

    private String name;
    private int age;

    // No-argument constructor
    Patient() {
        this("Unknown", 18);
    }

    // Parameterized constructor
    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display method
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println();
    }
}

public class ConstructorDemo {

    public static void main(String[] args) {

        // Calling no-argument constructor
        Patient p1 = new Patient();

        // Calling parameterized constructor
        Patient p2 = new Patient("Suji", 20);

        // Display patient details
        p1.display();
        p2.display();
    }
}