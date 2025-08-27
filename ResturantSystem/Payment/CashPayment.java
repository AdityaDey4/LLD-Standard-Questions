package ResturantSystem.Payment;

public class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println(amount+" rupees has been paid using CASH");
    }
    
}
