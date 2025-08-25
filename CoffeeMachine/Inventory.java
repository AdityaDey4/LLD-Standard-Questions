package CoffeeMachine;

import java.util.*;

public class Inventory {
    
    private static Inventory inventory;
    Map<String, Integer> availableIng;

    private Inventory(){
        availableIng = new HashMap();
    }

    public static Inventory getInventoryInstance() {

        if(inventory == null) {
            inventory = new Inventory();
        }

        return inventory;
    }

    public void addIngredient(String name, int qnt) {
        availableIng.put(name, availableIng.getOrDefault(name, 0)+qnt);
    }

    public void removeIngredient(String name, int qnt) {
        availableIng.put(name, availableIng.get(name)-qnt);
    }

    public boolean checkIngredient(String name, int qnt) {
        return availableIng.containsKey(name) && availableIng.get(name) >= qnt;
    }

    public int getQunatity(String name) {
        return availableIng.get(name);
    }
}
