package ru.kata.spring.boot_security.demo.controller;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class RestAdminController {

    private final UserService userService;

    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUserRest() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserByIdRest(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PatchMapping("/{id}")
    public User editUserRest(@RequestBody User user, @PathVariable Long id) {
        userService.update(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUserRest(@PathVariable Long id) {
        userService.deleteById(id);
        return "Ok";
    }
}
