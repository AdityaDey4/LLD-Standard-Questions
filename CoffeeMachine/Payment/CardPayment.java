package CoffeeMachine.Payment;

public class CardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println(amount+ " has been paid using Card");
    }

}
