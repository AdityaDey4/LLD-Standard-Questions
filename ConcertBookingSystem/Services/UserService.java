package ConcertBookingSystem.Services;

import java.util.HashMap;
import java.util.Map;

import ConcertBookingSystem.Exceptions.InvalidIdException;
import ConcertBookingSystem.Models.User;

public class UserService {
    private Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(int id) {
        if (!users.containsKey(id)) throw new InvalidIdException("Invalid User ID: " + id);
        return users.get(id);
    }

}
