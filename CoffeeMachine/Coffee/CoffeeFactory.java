package CoffeeMachine.Coffee;

import CoffeeMachine.Enum.CoffeeType;

public class CoffeeFactory {
    
    public static Coffee getCoffeeInstance(CoffeeType type) {

        if(type == CoffeeType.CAPPACCINO) {
            return new Cappaccino(150, "Cappaccino");
        } else if(type == CoffeeType.ESPRESSO) {
            return new Espresso(100, "Espresso");
        } else {
            return null;
        }
    }
}
