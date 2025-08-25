package VendingMachine.VendingStates.Impl;

import java.util.List;


import VendingMachine.VendingMachine;
import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;
import VendingMachine.VendingStates.State;

public class DispenseState implements State {

    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently Vending Machine is in Dispense State");
        dispenceProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Insert coin button can not clicked on Dispense state");
    }

    @Override
    public void clickOnStartPrroductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You have already choosed product.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Change already returned");
    }

    @Override
    public ItemTypes dispenceProduct(VendingMachine machine, int codeNumber) throws Exception {
        ItemTypes item = machine.getInventory().removeItem(codeNumber);
        System.out.println("Product has been dispensed");
        machine.setVendingMachineState(new IdleState(machine));
        return item;

    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, int codeNumber, int quantity) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }
    
}
