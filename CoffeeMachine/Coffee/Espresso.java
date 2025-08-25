package CoffeeMachine.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Espresso extends Coffee {

    Espresso(int price, String name) {
        super(price, name);
        setUpIngredient();
    }

    private void setUpIngredient() {
        Map<String, Integer> espressoIngredient = new HashMap<>();
        espressoIngredient.put("Milk", 50);
        espressoIngredient.put("Coffee", 5);
        espressoIngredient.put("Suger", 10);
        super.setIngredients(espressoIngredient);
    }

    @Override
    public void makeCoffee() {
        System.out.println("Espresso Coffee has been made. Ingredients used : "+super.ingredients);
    }
    
}
