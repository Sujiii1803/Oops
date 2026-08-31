package Polymorphism;

class Employee{
    void calculateSalary(){
        System.out.println("Salary is calculated");
    }
}
class FullTimeEmployee extends Employee{
    @Override
    void calculateSalary()
    {
        System.out.println("Salary for FullTimeEmployee : 50000");
    }
}
class PartTimeEmployee extends Employee{
    @Override
    void calculateSalary()
    {
        System.out.println("Salary for PartTimeEmployee : 20000");

    }
}
class Intern extends Employee{
    @Override
    void calculateSalary()
    {
        System.out.println("Salary for Intern : 10000");

    }
}
public class EmployeeDemo {
   public static void main(String[] args) {
       Employee employee;

       employee = new FullTimeEmployee();
       employee.calculateSalary();

       employee = new PartTimeEmployee();
       employee.calculateSalary();

       employee = new Intern();
       employee.calculateSalary();

   }
}
