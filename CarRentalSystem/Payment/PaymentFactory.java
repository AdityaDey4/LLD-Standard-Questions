package CarRentalSystem.Payment;

import CarRentalSystem.Enum.PaymentType;

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
