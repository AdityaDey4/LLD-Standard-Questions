package CoffeeMachine;

import CoffeeMachine.Coffee.Coffee;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.addIngredient("Milk", 100);
        machine.addIngredient("Coffee", 20);
        machine.addIngredient("Suger", 24);
        machine.addIngredient("Chocolate", 100);
        try {
            Coffee coffee = machine.select();
            machine.payAndMake(coffee);

            coffee = machine.select();
            machine.payAndMake(coffee);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
