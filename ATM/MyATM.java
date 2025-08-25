package ATM;

import ATM.BackendData.Details;
import ATM.State.IdleState;
import ATM.State.State;

public class MyATM {
    private String id;
    private State state;
    private int availableCash;
    private String cardNumber;
    private Details details;

    public MyATM(String id, int cash) {
        this.id = id;
        state = new IdleState(this);
        availableCash = cash;
        cardNumber = null;
        details = Details.getInstance();
    }

    public Details getBackendData() {
        return this.details;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getAvailableCash() {
        return this.availableCash;
    }

    public void creditCash(int amount) {
        this.availableCash+=amount;
    }

    public void debitCash(int amount) {
        this.availableCash-=amount;
    }

    public void setCardNumber(String cn) {
        this.cardNumber = cn;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void insertCard(String cardNumber) throws Exception {
        this.getState().insertCard(cardNumber);
    }
    public void enterPin(int pin) throws Exception {
        this.getState().enterPin(pin);
    }
    public void withdrawMoney(int amount) throws Exception {
        this.getState().withdrawMoney(amount);
    }
    public int checkBankBalance() throws Exception {
        return this.getState().checkBankBalance();
    }
    public void ejectCard() throws Exception { 
        this.getState().ejectCard();
    }
}
