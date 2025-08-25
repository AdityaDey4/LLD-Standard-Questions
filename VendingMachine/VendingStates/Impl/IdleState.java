package VendingMachine.VendingStates.Impl;

import java.util.ArrayList;
import java.util.List;


import VendingMachine.VendingMachine;
import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;
import VendingMachine.VendingStates.State;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Cuurntly Vending Machine is in Idle State");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Vending Machine is in Idle State");
        machine.setCoinList(new ArrayList<Coin>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartPrroductSelectionButton(VendingMachine machine) throws Exception{
        throw new Exception("first you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you can not choose Product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public ItemTypes dispenceProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, int codeNumber, int quantity) throws Exception {
        machine.getInventory().addItem(codeNumber, quantity);
    }
    
}
