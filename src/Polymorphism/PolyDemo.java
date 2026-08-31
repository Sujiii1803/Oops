package Polymorphism;

class Payment{
    void pay(){
        System.out.println("pay");
    }
}
class UPIPayment extends Payment{
      @Override
      void pay(){
          System.out.println("pay using UPI");
      }
}
class CreditCardPayment extends Payment{
      @Override
      void pay(){
          System.out.println("pay using CreditCard");
      }
}
class CashPayment extends Payment{
    @Override
    void pay(){
        System.out.println("pay using Cash");
    }
}

public class PolyDemo {
    public static void main(String[] args) {
        Payment pay;
        pay = new UPIPayment();
        pay.pay();

        pay = new CreditCardPayment();
        pay.pay();

        pay = new CashPayment();
        pay.pay();
    }
}
