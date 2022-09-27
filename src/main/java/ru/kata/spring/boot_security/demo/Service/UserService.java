package ru.kata.spring.boot_security.demo.Service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> getUsers();
    List<Role> getRoles();
    User getUserById(Long id);
    void save(User user);
    void update(Long id, User updateUser);
    void deleteById(Long id);

    void saveRole(Role user);
}
