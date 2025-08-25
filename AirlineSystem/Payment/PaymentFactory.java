package AirlineSystem.Payment;

import AirlineSystem.Enum.PaymentType;

public class PaymentFactory {
    
    private PaymentFactory(){};

    public static Payment getPaymentMethod(PaymentType type) {
        if(type == PaymentType.UPI) {
            return new UPIPayment();
        } else {
            return new CashPayment();
        }
    }
}
