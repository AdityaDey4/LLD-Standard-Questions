package CoffeeMachine.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Cappaccino extends Coffee {

    Cappaccino(int price, String name) {
        super(price, name);
        setUpIngredient();
    }

    private void setUpIngredient() {
        Map<String, Integer> espressoIngredient = new HashMap<>();
        espressoIngredient.put("Milk", 50);
        espressoIngredient.put("Coffee", 7);
        espressoIngredient.put("Suger", 12);
        espressoIngredient.put("Chocolate", 100);
        super.setIngredients(espressoIngredient);
    }

    @Override
    public void makeCoffee() {
        System.out.println("Espresso Coffee has been made. Ingredients used : "+super.ingredients);
    }
    
}
