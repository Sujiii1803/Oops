package CLASS_OBJECT;

class Student {

    // Instance variables (State)
    int id;
    String name;
    int age;
    String department;

    // Method (Behavior)
    void study() {
        System.out.println(name + " is studying.");
    }

    void displayDetails() {
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + department);
        System.out.println("-----------------------------");
    }
}

public class ClassAndObjectDemo {

    public static void main(String[] args) {

        // Creating first object
        Student student1 = new Student();

        student1.id = 101;
        student1.name = "Alice";
        student1.age = 20;
        student1.department = "Computer Science";

        // Creating second object
        Student student2 = new Student();

        student2.id = 102;
        student2.name = "Bob";
        student2.age = 21;
        student2.department = "Information Technology";

        // Calling methods using objects
        student1.displayDetails();
        student1.study();

        System.out.println();

        student2.displayDetails();
        student2.study();
    }
}