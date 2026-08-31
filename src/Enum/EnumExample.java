package Enum;

// Enum representing the status of an order
enum OrderStatus {
    PENDING,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}

public class EnumExample {

    public static void main(String[] args) {

        // Assigning an enum value
        OrderStatus status = OrderStatus.SHIPPED;

        System.out.println("Current Status: " + status);

        // Using enum with switch
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

        // values() - returns all enum constants
        System.out.println("\nAll Order Statuses:");

        for (OrderStatus orderStatus : OrderStatus.values()) {
            System.out.println(orderStatus);
        }

        // valueOf() - converts String to enum
        OrderStatus newStatus = OrderStatus.valueOf("DELIVERED");

        System.out.println("\nConverted Status: " + newStatus);

        // ordinal() - returns the position of the enum constant
        System.out.println("Position of DELIVERED: "
                + OrderStatus.DELIVERED.ordinal());
    }
}
