package ResturantSystem.Bill;

public class Bill {
    private BillComponent component;

    public Bill(BillComponent component) {
        this.component = component;
    }

    public void printBill() {
        System.out.println("--- BILL ---");
        System.out.println("Description: \n"+ component.getDescription());
        System.out.println("Total: "+ component.calculateTotal());
        System.out.println("------------");
    }

    public BillComponent getBillComponent() {
        return this.component;
    }

    public void setBillComponent(BillComponent newComponent) {
        this.component = newComponent;
    }
}
