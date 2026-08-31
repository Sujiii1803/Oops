package Encapsulation;

class BankAccount {

    // Private fields
    // These cannot be accessed directly from outside the class
    private String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    // Getter for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}


// Main class
public class EncapsulationDemo {

    public static void main(String[] args) {

        // Creating an object
        BankAccount account = new BankAccount("Suji", 10000);

        // Accessing data through public methods
        account.displayAccountDetails();

        System.out.println();

        // Deposit
        account.deposit(5000);

        // Withdraw
        account.withdraw(3000);

        System.out.println();

        // Display updated balance
        account.displayAccountDetails();

        System.out.println();

        // Accessing private data through getter
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Current Balance: " + account.getBalance());

        /*
         * This is NOT allowed because balance is private:
         *
         * account.balance = 50000;
         *
         * Instead, we must use the methods provided by BankAccount.
         */
    }
}