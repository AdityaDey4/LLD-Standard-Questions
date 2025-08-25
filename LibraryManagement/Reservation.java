package LibraryManagement;

import java.util.*;

public class Reservation {
    
    Map<Book, List<User>> map = new HashMap<>();

    public void notifyUsers(Book book) {
        if(!map.containsKey(book)) return;

        for(User user : map.get(book)) {
            System.out.println("Hello "+user.name+" ,Book name : "+book.getName()+" is available now");
        }

        map.remove(book);
    }

    public void addUser(Book book, User user) {
        map.putIfAbsent(book, new ArrayList<>());
        map.get(book).add(user);
    }
}
