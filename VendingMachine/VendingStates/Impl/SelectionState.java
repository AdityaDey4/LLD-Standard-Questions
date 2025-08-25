package VendingMachine.VendingStates.Impl;

import java.util.List;

import VendingMachine.ItemShelf;
import VendingMachine.VendingMachine;
import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;
import VendingMachine.VendingStates.State;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending Machine is in Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You have already insered coins, so please select the istems now.");
    }

    @Override
    public void clickOnStartPrroductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You have already insered coins, so please select the istems now.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        ItemShelf item = machine.getInventory().getItem(codeNumber); // it might throw exception if item is sold out
        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()) {
            paidByUser+=coin.value;
        }

        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount. You Paid : "+paidByUser+" and selected amount cost is : "+item.getPrice());

            refundFullMoney(machine);
            throw new Exception("Insufficient Amount");
        } else if(item.isSoldOut()) {
            System.out.println("Sorry Item is sold out");

            refundFullMoney(machine);
            throw new Exception("Item Sold Out");
        } else {
            getChange(paidByUser-item.getPrice());
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;

    }

    @Override
    public ItemTypes dispenceProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();

    }

    @Override
    public void updateInventory(VendingMachine machine, int codeNumber,int quantity) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
    
}
