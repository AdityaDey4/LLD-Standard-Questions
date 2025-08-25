package DigitalWalletService.Repository;

import java.util.HashMap;
import java.util.Map;

import DigitalWalletService.User;

public class UserRepo {
    private final Map<String, User> users = new HashMap<>();

    public void saveUser(User user){users.put(user.getId(), user);};
    public User findUserById(String id) {
        if(!users.containsKey(id)) return null;

        return users.get(id);
    }
}
