package ATM.State;

import ATM.MyATM;
import ATM.BackendData.Data;

public class ProcessingState implements State {

    private MyATM atm;

    public ProcessingState(MyATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) throws Exception {
        throw new Exception("You can't insert card in Processing State");
    }

    @Override
    public void enterPin(int pin) throws Exception {
        throw new Exception("You can't enter pin State");
    }

    @Override
    public void withdrawMoney(int amount) throws Exception {
        
        Data details = this.atm.getBackendData().getSpecificData(this.atm.getCardNumber());
        if(details.getAmount() < amount) {
            this.atm.setState(new EjectState(atm));
            this.atm.getState().ejectCard();
            throw new Exception("Insufficient Fund, please remove your card");
        }

        if(atm.getAvailableCash() < amount) {
            this.atm.setState(new EjectState(atm));
            this.atm.getState().ejectCard();
            throw new Exception("Insufficient Fund in ATM, please remove your card");
        }

        details.debitAmount(amount);
        atm.debitCash(amount);
        dispenceAmount(amount);
        atm.setState(new EjectState(atm));
    }

    @Override
    public int checkBankBalance() throws Exception {
        Data details = this.atm.getBackendData().getSpecificData(this.atm.getCardNumber());
        atm.setState(new EjectState(atm));
        return details.getAmount();
    }

    private void dispenceAmount(int amount) {
        System.out.println(amount+" has been dispenced successfully");
    }

    @Override
    public void ejectCard() throws Exception {
        throw new Exception("You can't eject card in Processing state");
    }
    
}
