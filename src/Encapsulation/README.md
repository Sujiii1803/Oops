# Encapsulation

## Definition

Encapsulation is the process of bundling data and methods that operate on
that data inside a class and controlling access to the internal state.

## Key Idea

Data should not be directly accessible from outside the class.

Instead:

Outside Code
↓
Public Method
↓
Validation / Business Logic
↓
Private Data

## How Encapsulation is Achieved in Java

- private fields
- public/protected methods when appropriate
- getters and setters when appropriate
- validation
- controlled modification of object state

## Example

class BankAccount {

    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

## Why use Encapsulation?

1. Data hiding
2. Controlled access
3. Validation
4. Better maintainability
5. Reduced coupling
6. Protects object state

## Data Hiding vs Encapsulation

Data hiding:
Preventing direct access to internal data.

Encapsulation:
Combining state and behavior and controlling how the state is accessed
or modified.

Data hiding is one part of achieving encapsulation.

## Important Point

Encapsulation does NOT mean:

private variables + getter + setter for every field.

The goal is controlled access.

For example, instead of:

setBalance(5000)

a BankAccount may provide:

deposit(5000)
withdraw(1000)

because the class can enforce its business rules.

## Encapsulation vs Abstraction

Encapsulation → controls access to data/state.

Abstraction → hides unnecessary implementation details.

## Interview Definition

Encapsulation is an OOP principle that bundles an object's state and
behavior into a class while restricting direct access to its internal
state and providing controlled access through appropriate methods.