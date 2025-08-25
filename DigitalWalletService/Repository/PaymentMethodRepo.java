package DigitalWalletService.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DigitalWalletService.User;
import DigitalWalletService.PaymentMethod.PaymentMethod;

public class PaymentMethodRepo {
    
    private final Map<String, PaymentMethod> paymentMethods = new HashMap<>();

    public void savePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public void removePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.remove(paymentMethod.getId());
    }

    public PaymentMethod findPaymentMethodById(String id) {
        if(!paymentMethods.containsKey(id)) return null;

        return paymentMethods.get(id);
    }

    public List<PaymentMethod> getPaymentMethodsOfUsers(User user) {

        List<PaymentMethod> list = new ArrayList<>();
        for(PaymentMethod method : paymentMethods.values()) {
            if(method.getUser().getId().equals(user.getId())) {
                list.add(method);
            }
        }

        return list;
    }
}
