package VendingMachine;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.EnumClasses.Coin;
import VendingMachine.VendingStates.State;
import VendingMachine.VendingStates.Impl.IdleState;

public class VendingMachine {
    private State currentState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        currentState = new IdleState();
        inventory = new Inventory();
        coinList = new ArrayList<>();
    }

    public State getVendingMachineState() {
        return currentState;
    }

    public void setVendingMachineState(State state) {
        this.currentState = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
