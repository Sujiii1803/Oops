# Enum in Java

## What is an Enum?

An **enum (enumeration)** in Java is a special data type used to represent a **fixed set of constants**.

For example, an order can have a fixed set of statuses:

```text
PENDING
CONFIRMED
SHIPPED
DELIVERED
CANCELLED
```

Instead of using `String` values, Java provides `enum` to represent these predefined values in a type-safe way.

---

## Basic Syntax

```java
enum OrderStatus {
    PENDING,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
```

Using the enum:

```java
OrderStatus status = OrderStatus.SHIPPED;
```

Here:

* `OrderStatus` is the enum type.
* `SHIPPED` is an enum constant.
* `status` is a variable of type `OrderStatus`.

---

## Why Use Enum?

Using `String`:

```java
String status = "SHIPPED";
```

This allows invalid values:

```java
status = "ABC";
```

With an enum:

```java
OrderStatus status = OrderStatus.SHIPPED;
```

Only the values defined inside `OrderStatus` can be assigned.

This provides:

* Type safety
* Better readability
* Controlled values
* Easier maintenance
* Fewer invalid values

---

## Enum with Switch

Enums can be used with a `switch` statement.

```java
switch (status) {

    case PENDING:
        System.out.println("Order is waiting for confirmation.");
        break;

    case CONFIRMED:
        System.out.println("Order has been confirmed.");
        break;

    case SHIPPED:
        System.out.println("Order has been shipped.");
        break;

    case DELIVERED:
        System.out.println("Order has been delivered.");
        break;

    case CANCELLED:
        System.out.println("Order has been cancelled.");
        break;
}
```

---

## Important Enum Methods

### 1. `values()`

`values()` returns all the constants defined inside the enum.

```java
for (OrderStatus status : OrderStatus.values()) {
    System.out.println(status);
}
```

Output:

```text
PENDING
CONFIRMED
SHIPPED
DELIVERED
CANCELLED
```

---

### 2. `valueOf()`

`valueOf()` converts a `String` into the corresponding enum constant.

```java
OrderStatus status = OrderStatus.valueOf("DELIVERED");

System.out.println(status);
```

Output:

```text
DELIVERED
```

The string must match the enum constant exactly.

```java
OrderStatus.valueOf("delivered");
```

This will throw an `IllegalArgumentException` because `delivered` and `DELIVERED` are different.

---

### 3. `ordinal()`

`ordinal()` returns the position of an enum constant.

The position starts from `0`.

```java
System.out.println(OrderStatus.PENDING.ordinal());
System.out.println(OrderStatus.SHIPPED.ordinal());
System.out.println(OrderStatus.DELIVERED.ordinal());
```

Output:

```text
0
2
3
```

### Important

Avoid using `ordinal()` as a permanent ID or database value because changing the order of enum constants changes their ordinal values.

---

## Enum Can Have Fields and Methods

An enum can also contain:

* Fields
* Constructors
* Methods

Example:

```java
enum PaymentStatus {

    PENDING("Payment is pending"),
    SUCCESS("Payment completed"),
    FAILED("Payment failed");

    private String message;

    PaymentStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

Usage:

```java
PaymentStatus status = PaymentStatus.SUCCESS;

System.out.println(status);
System.out.println(status.getMessage());
```

Output:

```text
SUCCESS
Payment completed
```

---

## Enum Constructors

Enum constructors are implicitly `private`.

For example:

```java
PaymentStatus(String message) {
    this.message = message;
}
```

We cannot create an enum object using `new`.

```java
PaymentStatus status =
    new PaymentStatus("Payment completed");
```

This is not allowed.

The enum constants are created automatically:

```java
PaymentStatus.PENDING
PaymentStatus.SUCCESS
PaymentStatus.FAILED
```

---

## Enum vs String

| Feature                    | String        | Enum          |
| -------------------------- | ------------- | ------------- |
| Fixed values               | No            | Yes           |
| Type safety                | No            | Yes           |
| Invalid values possible    | Yes           | No            |
| Readability                | Lower         | Higher        |
| Can use with switch        | Yes           | Yes           |
| Suitable for fixed choices | Less suitable | Very suitable |

---

## Real-World Uses

Enums are commonly used for values that have a fixed set of options.

### User Roles

```java
enum Role {
    ADMIN,
    USER,
    MANAGER
}
```

### Payment Status

```java
enum PaymentStatus {
    PENDING,
    SUCCESS,
    FAILED
}
```

### Order Status

```java
enum OrderStatus {
    PLACED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
```

### Days

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

---

## Key Points

* `enum` is used for a **fixed set of constants**.
* Enum provides **type safety**.
* Enum constants are instances of the enum type.
* Enum can contain **fields, constructors, and methods**.
* Enum constructors are implicitly `private`.
* `values()` returns all enum constants.
* `valueOf()` converts a `String` into an enum constant.
* `ordinal()` returns the position of an enum constant.
* Enums are useful for statuses, roles, directions, days, categories, and other fixed choices.

---

## Example Output

```text
Current Status: SHIPPED
Order has been shipped.

All Order Statuses:
PENDING
CONFIRMED
SHIPPED
DELIVERED
CANCELLED

Converted Status: DELIVERED
Position of DELIVERED: 3
```

---

## File Structure

```text
Enum/
│
├── EnumExample.java
└── README.md
```
