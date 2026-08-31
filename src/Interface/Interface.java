package Interface;

// Interface
interface Payment {

    // Abstract method
    void pay();

    // Default method
    default void paymentStatus() {
        System.out.println("Payment processing...");
    }
}

// First implementation
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made using UPI");
    }
}

// Second implementation
class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made using Credit Card");
    }
}

// Main class
public class Interface {

    public static void main(String[] args) {

        // Interface reference pointing to UpiPayment object
        Payment payment1 = new UpiPayment();

        payment1.pay();
        payment1.paymentStatus();

        System.out.println();

        // Interface reference pointing to CardPayment object
        Payment payment2 = new CardPayment();

        payment2.pay();
        payment2.paymentStatus();
    }
}



