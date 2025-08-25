package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

import LibraryManagement.Payment.Payment;

public class Library {
    
    private static Library library;
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Reservation reservation = new Reservation();

    private Library(){};
    public static Library getInstance() {
        if(library == null) {
            library = new Library();
        }

        return library;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void issueBook(List<Book> books, User user, int issueDate) {

        for(Book book : books) {
            if(book.checkAvailablity()) {
                book.reduceQuantity();
                Record record = new Record(book, issueDate);
                user.history.addHistory(record);

                System.out.println("Book name : "+book.getName()+" is issued");
            }else {
                reservation.addUser(book, user);
                System.out.println("Book name : "+book.getName()+" isn't available, you will be notified one available");
            }
        }
    }

    public void returnBook(List<Book> books, Payment payment, User user, int returnDate) {

        double totalFine = 0;

        for(Book book : books) {
            for(Record record : user.history.records) {
                if(book == record.book && !record.finePaid) {
                    totalFine+= record.changeRecord(returnDate);
                    book.increseQuantity();
                    System.out.println("Book name : "+book.getName()+" is returned");
                    reservation.notifyUsers(book);
                    break;
                }
            }
        }

        payment.pay(totalFine);
    }
}
