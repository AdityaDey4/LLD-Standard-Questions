package StackOverflow.Repos;

import java.util.*;
import StackOverflow.Models.User;

public class UserRepo {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) { users.put(user.getId(), user); }
    public User findById(String id) { return users.get(id); }
    public List<User> findAll() { return new ArrayList<>(users.values()); }
}
