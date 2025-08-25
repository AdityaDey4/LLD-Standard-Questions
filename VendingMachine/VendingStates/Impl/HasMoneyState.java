package VendingMachine.VendingStates.Impl;

import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;
import VendingMachine.VendingStates.State;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently Vending Machine is in Has Money State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartPrroductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        machine.getCoinList().add(coin);
        System.out.println("Amount : "+machine.getCoinList());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in Has Money state");
    }

    @Override
    public ItemTypes dispenceProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product can not be dispensed in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        List<Coin> coin = machine.getCoinList();
        int totalAmount = 0;
        for(Coin c : coin) {
            totalAmount+=c.value;
        }
        System.out.println("Returning full amount back to customer (Has Money) : "+totalAmount);
        machine.setVendingMachineState(new IdleState(machine));
        return coin;
    }

    @Override
    public void updateInventory(VendingMachine machine, int codeNumber, int quantity) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }    
}
