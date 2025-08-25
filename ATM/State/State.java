package ATM.State;

public interface State {
    public void insertCard(String cardNumber) throws Exception;
    public void enterPin(int pin) throws Exception;
    public void withdrawMoney(int amount) throws Exception;
    public int checkBankBalance() throws Exception;
    public void ejectCard() throws Exception;
}