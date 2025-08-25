package CoffeeMachine.Coffee;

import java.util.*;

public abstract class Coffee {
    private int price;
    private String name;
    Map<String, Integer> ingredients;

    Coffee(int price, String name) {
        this.price = price;
        this.name = name;
        ingredients = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
    
    public void setIngredients(Map<String, Integer> map) {
        this.ingredients = map;
    }

    public Map<String, Integer> getIngredients() {
        return this.ingredients;
    }

    public Map<String, Integer> getRequiredIngredient() {
        return this.ingredients;
    }

    public abstract void makeCoffee();
}
