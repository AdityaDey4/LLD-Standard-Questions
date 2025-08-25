package CoffeeMachine.States;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import CoffeeMachine.Machine;
import CoffeeMachine.Coffee.Coffee;
import CoffeeMachine.Enum.PaymentType;
import CoffeeMachine.Payment.Payment;
import CoffeeMachine.Payment.PaymentFactory;

public class MakingState implements State {

    Machine machine;
    public MakingState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public Coffee showCoffeeList() throws Exception {
        throw new UnsupportedOperationException("Coffee has already been selected");
    }

    @Override
    public Coffee selectCoffee(List<Coffee> coffee) throws Exception {
        throw new UnsupportedOperationException("Coffee has already been selected");
    }

    @Override
    public void makePayment(Coffee coffee) throws Exception {

        Map<Integer, PaymentType> map = new HashMap();
        int index = 1;
        for(PaymentType type : PaymentType.values()) {

            System.out.println("["+ index +"] Mode : "+type);
            map.put(index, type);
            index++;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Please select the Payment Mode index : ");
        int paymentIndex = sc.nextInt();
        System.out.println();

        if(paymentIndex <=0 || paymentIndex > PaymentType.values().length) {
            machine.setState(new IdleState(machine));
            throw new Exception("Invalid payment index selected");
        }

        System.out.print("Please enter the amount : ");
        int amount = sc.nextInt();
        System.out.println();
        
        if(coffee.getPrice() > amount) {
            dispenceChange(amount);
            machine.setState(new IdleState(machine));
            throw new Exception("Insufficient Fund");
        }

        PaymentType paymentType = map.get(paymentIndex);
        Payment payment = PaymentFactory.getPaymentInstance(paymentType);
        payment.pay(amount);

        makeCoffee(coffee);

        int remain = amount-coffee.getPrice();
        if(remain > 0) dispenceChange(remain);

        machine.setState(new IdleState(machine));
    }

    @Override
    public void makeCoffee(Coffee coffee) throws Exception {
        coffee.makeCoffee();
        machine.useRequiredIngredients(coffee);
        dispenceCoffee(coffee.getName());
    }

    @Override
    public void dispenceCoffee(String name) throws Exception {
        System.out.println("Here is your : "+name);
    }

    @Override
    public void dispenceChange(int amount) throws Exception {
        System.out.println("Here is your change amount : "+amount);
    }
    
}
