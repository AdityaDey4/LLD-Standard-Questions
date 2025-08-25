package CoffeeMachine;

import java.util.Map;

import CoffeeMachine.Coffee.Coffee;
import CoffeeMachine.States.IdleState;
import CoffeeMachine.States.State;

public class Machine {
    State state;
    Inventory inventory;

    Machine() {
        state = new IdleState(this);
        inventory = Inventory.getInventoryInstance();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public Coffee select() throws Exception {
        return state.showCoffeeList();
    }

    public void payAndMake(Coffee coffee) throws Exception {
        state.makePayment(coffee);
    }

    public void useRequiredIngredients(Coffee coffee) {

        Map<String, Integer> map = coffee.getIngredients();

        for(String key : map.keySet()) {
            inventory.removeIngredient(key, map.get(key));
            if(inventory.getQunatity(key) < 5) {
                System.out.println(key+" is available only "+inventory.getQunatity(key)+", will finish soon");
            }
        }
    }

    public boolean checkIngredientAvailable(Coffee coffee) {
        
        Map<String, Integer> map = coffee.getIngredients();
        for(String key : map.keySet()) {
            if(!inventory.checkIngredient(key, map.get(key))) return false;
        }
        return true;
    }

    public void addIngredient(String name, int qnt) {
        inventory.addIngredient(name, qnt);
    }
}
