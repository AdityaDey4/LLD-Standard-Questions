package VendingMachine.VendingStates;

import java.util.*;

import VendingMachine.VendingMachine;
import VendingMachine.EnumClasses.Coin;
import VendingMachine.EnumClasses.ItemTypes;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void clickOnStartPrroductSelectionButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
    public int getChange(int returnChangeMoney) throws Exception;
    public ItemTypes dispenceProduct(VendingMachine machine, int codeNumber) throws Exception;
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    public void updateInventory(VendingMachine machine, int codeNumber, int quantity) throws Exception;
}
