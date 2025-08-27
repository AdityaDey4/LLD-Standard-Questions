package ResturantSystem.Bill;

public class TaxDecorator extends BillDecorator {

    public TaxDecorator(BillComponent component) {
        super(component);
    }

    @Override
    public double calculateTotal() {
        double total =  super.calculateTotal();
        double withTax = total+((total*18)/100);

        return withTax;
    }

    @Override
    public String getDescription() {
        double total =  super.calculateTotal();
        double tax = (total*18)/100;
        return super.getDescription() + "Tax (18%) : " + tax+ "\n";
    }
}
