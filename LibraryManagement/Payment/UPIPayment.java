package LibraryManagement.Payment;

public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println(amount+" rupees has been paid using UPI");
    }
    
}
