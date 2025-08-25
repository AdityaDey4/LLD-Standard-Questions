package CoffeeMachine.States;

import java.util.List;

import CoffeeMachine.Coffee.Coffee;

public interface State {
    public Coffee showCoffeeList() throws Exception;
    public Coffee selectCoffee(List<Coffee> coffee) throws Exception;
    public void makePayment(Coffee coffee) throws Exception;
    public void makeCoffee(Coffee coffee) throws Exception;
    public void dispenceCoffee(String name) throws Exception;
    public void dispenceChange(int amount) throws Exception;
}
