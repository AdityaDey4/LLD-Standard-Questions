package StackOverflow.Services;

import java.util.List;
import java.util.UUID;
import StackOverflow.Models.User;
import StackOverflow.Repos.UserRepo;

public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(String name, String email) {
        User user = new User(UUID.randomUUID().toString(), name, email);
        userRepo.save(user);
        return user;
    }

    public User getUserById(String id) {
        return userRepo.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
