package LibraryManagement.Payment;

import LibraryManagement.Enum.PaymentType;

public class PaymentFactory {
    
    private PaymentFactory(){};

    public static Payment getPaymentMethod(PaymentType type) {
        if(type == PaymentType.CASH) {
            return new CashPayment();
        } else {
            return new UPIPayment();
        }
    }
}
