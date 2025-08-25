package ATM.BackendData;

public class Data {
    private String cardNumber;
    private int pin;
    private int amount;

    public Data(String cn, int p, int a) {
        this.cardNumber = cn;
        this.pin = p;
        this.amount = a;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getPin() {
        return this.pin;
    }

    public int getAmount() {
        return this.amount;
    }

    public void debitAmount(int amount) {
        this.amount-=amount;
    }
}
