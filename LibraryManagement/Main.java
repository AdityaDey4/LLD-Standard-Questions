package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

import LibraryManagement.Enum.PaymentType;

public class Main {
    public static void main(String args[]) {
        System.out.println();

        Library library = Library.getInstance();

        Book book1 = new Book("ABC", 1, "1234");
        Book book2 = new Book("DEF", 2, "2345");
        

        User user1 = new User("001", "Aditya Dey");

        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        user1.issueBooks(list, 1);
         System.out.println();

        User user2 = new User("002", "Rudra Mondal");
         user2.issueBooks(list, 1);
        System.out.println();

        list.remove(0);
        user1.returnBook(list, PaymentType.CASH, 23);
        System.out.println();

        list.remove(0);
        list.add((book1));
         user1.returnBook(list, PaymentType.UPI, 25);
        System.out.println();
    }
}
