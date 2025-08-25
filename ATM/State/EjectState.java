package ATM.State;

import ATM.MyATM;

public class EjectState implements State {

    private MyATM atm;

    public EjectState(MyATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) throws Exception {
        throw new Exception("You can't insert card in Eject State");
    }

    @Override
    public void enterPin(int pin) throws Exception {
        throw new Exception("You can't enter pin in Eject State");
    }

    @Override
    public void withdrawMoney(int amount) throws Exception {
        throw new Exception("You can't withdraw in Processing State");
    }

    @Override
    public int checkBankBalance() throws Exception {
        throw new Exception("You can't check bank balance in Processing State");
    }

    @Override
    public void ejectCard() throws Exception {
        System.out.println("Card Numbered : "+atm.getCardNumber()+" is ejected");
        atm.setCardNumber(null);
        atm.setState(new IdleState(atm));
    }
    
}
