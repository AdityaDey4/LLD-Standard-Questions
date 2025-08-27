package ResturantSystem.Service;

import ResturantSystem.Bill.*;

public class BillingService {
    private final double serviceCharge;

    public BillingService(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Bill decorate(Bill bill) {
        BillComponent comp = bill.getBillComponent();
        comp = new TaxDecorator(comp);
        comp = new ServiceChargeDecorator(comp, serviceCharge);
        bill.setBillComponent(comp);
        return bill;
    }
}
