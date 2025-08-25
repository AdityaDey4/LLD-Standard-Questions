package CoffeeMachine.States;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CoffeeMachine.Machine;
import CoffeeMachine.Coffee.Coffee;
import CoffeeMachine.Coffee.CoffeeFactory;
import CoffeeMachine.Enum.CoffeeType;

public class IdleState implements State {

    Machine machine;
    public IdleState(Machine machine) {
        this.machine = machine;
    }


    @Override
    public Coffee showCoffeeList() throws Exception {
       
        List<Coffee> coffees = new ArrayList<>();
        int index = 1;
        for(CoffeeType type : CoffeeType.values()) {

            Coffee cf = CoffeeFactory.getCoffeeInstance(type);
            coffees.add(cf);
            System.out.println("["+ index +"] Name : "+cf.getName()+" Price : "+cf.getPrice());
            index++;
        }

        return selectCoffee(coffees);
    }

    @Override
    public Coffee selectCoffee(List<Coffee> coffees) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Please select the coffee index : ");
        int index = sc.nextInt();
        System.out.println();

        if(coffees.size() < index || index <= 0) {
            throw new Exception("Invalid index selected");
        }
        machine.setState(new MakingState(machine));
        Coffee coffee = coffees.get(index-1);

        if(!machine.checkIngredientAvailable(coffee)) {
            machine.setState(new IdleState(machine));
            throw new Exception("Required ingredients are not available");
        }

        return coffee;
    }

    @Override
    public void makePayment(Coffee coffee) throws Exception {
        throw new UnsupportedOperationException("Select the coffee first");
    }

    @Override
    public void makeCoffee(Coffee coffee) throws Exception {
        throw new UnsupportedOperationException("Select the coffee first");
    }

    @Override
    public void dispenceCoffee(String name) throws Exception {
        throw new UnsupportedOperationException("Select the coffee first'");
    }

    @Override
    public void dispenceChange(int amount) throws Exception {
        throw new UnsupportedOperationException("Select the coffee first");
    }
    
}
