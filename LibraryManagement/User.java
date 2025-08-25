package LibraryManagement;

import java.util.List;

import LibraryManagement.Enum.PaymentType;
import LibraryManagement.Payment.Payment;
import LibraryManagement.Payment.PaymentFactory;

public class User {
    String id;
    String name;
    History history;

    public User(String id, String name) {
        this.name = name;
        this.id = id;
        history = new History();

        Library.getInstance().addUser(this);
    }

    public void issueBooks(List<Book> list, int issueDate) {
        Library.getInstance().issueBook(list, this, issueDate);
        this.history.printAllHistory();
    }

    public void returnBook(List<Book> list, PaymentType paymentType, int returnDate) {

        Payment payment = PaymentFactory.getPaymentMethod(paymentType);
        Library.getInstance().returnBook(list, payment, this, returnDate);
        this.history.printAllHistory();
    }
}
