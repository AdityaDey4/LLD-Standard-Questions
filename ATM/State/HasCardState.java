package ATM.State;

import ATM.MyATM;
import ATM.BackendData.Data;

public class HasCardState implements State{

    private MyATM atm;

    public HasCardState(MyATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) throws Exception {
        throw new Exception("You can't insert card in Has Card State");
    }

    @Override
    public void enterPin(int pin) throws Exception {
        Data currData = atm.getBackendData().getSpecificData(atm.getCardNumber());
        if(currData == null || currData.getPin() != pin) {
            this.atm.setState(new EjectState(atm));
            throw new Exception("Card Details or pin is not correct, please remove your card");
        }
        
        System.out.println("Authentication successfully completed");
        this.atm.setState(new ProcessingState(atm));
    }

    @Override
    public void withdrawMoney(int amount) throws Exception {
        throw new Exception("You can't withdraw money in Has Card State");
    }

    @Override
    public int checkBankBalance() throws Exception {
        throw new Exception("You can't check bank balance in Has Card State");
    }

    @Override
    public void ejectCard() throws Exception {
        throw new Exception("You can't eject card in Has Card State");
    }
    
}
