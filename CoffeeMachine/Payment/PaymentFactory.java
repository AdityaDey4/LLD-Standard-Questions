package CoffeeMachine.Payment;

import CoffeeMachine.Enum.PaymentType;

public class PaymentFactory {
    
    public static Payment getPaymentInstance(PaymentType type) {

        if(type == PaymentType.CARD) {
            return new CardPayment();
        } else if(type == PaymentType.CASH) {
            return new CashPayment();
        } else {
            return null;
        }
    }
}
