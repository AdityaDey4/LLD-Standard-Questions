package ATM.State;

import ATM.MyATM;

public class IdleState implements State{

    private MyATM atm;

    public IdleState(MyATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) throws Exception {
        System.out.println("Card Numbered : "+cardNumber+" is inserted");
        atm.setCardNumber(cardNumber);
        atm.setState(new HasCardState(atm));
    }

    @Override
    public void enterPin(int pin) throws Exception {
        throw new Exception("You Can't enter pin in Idle State");
    }

    @Override
    public void withdrawMoney(int amount) throws Exception {
        throw new Exception("You Can't withdraw money in Idle State");
    }

    @Override
    public int checkBankBalance() throws Exception {
        throw new Exception("You Can't check bank balance in Idle State");
    }

    @Override
    public void ejectCard() throws Exception {
        throw new Exception("You Can't eject card in Idle State");
    }
    
}
