package LibraryManagement.Enum;

public enum Constant {
    MAX_FREE_DAY(21),
    FINE_PER_DAY(5);

    public int value;
    Constant(int value) {
        this.value = value;
    }
}
