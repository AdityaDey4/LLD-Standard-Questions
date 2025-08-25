package ATM;

public class Main {

    public static void main(String[] args) {
        
        try {
            MyATM atm = new MyATM("ATM1", 4500);
            

            atm.insertCard("123456789012");
            atm.enterPin(1234);
            System.out.println("Bank Balance : "+atm.checkBankBalance());
            atm.ejectCard();

            atm.insertCard("123456789015");
            atm.enterPin(2345);
            atm.withdrawMoney(8000);
            atm.ejectCard();
        }catch(Exception e) {
            System.out.println("Exception : "+e);
        }
    }
}   
