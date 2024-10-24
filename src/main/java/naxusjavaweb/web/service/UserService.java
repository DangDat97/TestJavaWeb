package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User saveUser(User user);

    void deleteUser(int id);

    User updateUser(User user);

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

    List<User> getUsersByRole(String role);
}