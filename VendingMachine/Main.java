package VendingMachine;

import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;
import VendingMachine.VendingStates.State;

public class Main {

    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine(); // Idle State
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState(); 
            vendingState.clickOnInsertCoinButton(vendingMachine); // Has Money State

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

           vendingState.refundFullMoney(vendingMachine); // Idle State

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnStartPrroductSelectionButton(vendingMachine); // Selection State

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 101);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            System.out.println("Exception : "+e);
            displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getItemShelfInventory();
        for (int i = 0; i < slots.length; i++) {
            if(slots[i].getCode() == 101) {
                slots[i].setItemType(ItemTypes.COKE);
                slots[i].setPrice(12);
                slots[i].setQuantity(2);
            }else if(slots[i].getCode() == 102){
                slots[i].setItemType(ItemTypes.PEPSI);
                slots[i].setPrice(9);
                slots[i].setQuantity(4);
            }else if(slots[i].getCode() == 103){
                slots[i].setItemType(ItemTypes.JUICE);
                slots[i].setPrice(13);
                slots[i].setQuantity(3);
            }else if(slots[i].getCode() == 104){
                slots[i].setItemType(ItemTypes.SODA);
                slots[i].setPrice(7);
                slots[i].setQuantity(1);
            }
        }

        vendingMachine.getInventory().updateItemSoldOut();
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getItemShelfInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItemType() +
                    " Price: " + slots[i].getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut()+
                    " Quantity: " + slots[i].getQuantity());
        }
    }
}

