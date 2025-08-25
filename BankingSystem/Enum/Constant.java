package BankingSystem.Enum;

public enum Constant {
    
    INTEREST_RATE(.6),
    MAINTENANCE_CHARGE(50);

    public double val;
    Constant(double val) {
        this.val = val;
    }
}
