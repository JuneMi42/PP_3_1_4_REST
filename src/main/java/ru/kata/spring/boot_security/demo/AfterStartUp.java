package ru.kata.spring.boot_security.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class AfterStartUp {
    final UserService userService;

    public AfterStartUp(UserService userService) {
        this.userService = userService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        if (userService.getRoles().size()<1) {
            System.out.println("I am running........");
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            userService.saveRole(admin);
            userService.saveRole(user);
            Set<Role> roles = new HashSet<>();


            roles.add(user);
            User simpleUser = new User("user","userovich", 12, "User@mail.ru", "1");
            simpleUser.setRoles(roles);


            roles = new HashSet<>();
            roles.add(user);
            roles.add(admin);
            User adminUser = new User("admin","adminovich", 15,"Admin@mail.ru", "1");
            adminUser.setRoles(roles);


            userService.save(simpleUser);
            userService.save(adminUser);

            System.out.println("hello, I have just create few users: \n" +
                    "username: User@mail.ru      password: 1 \n" +
                    "username: Admin@mail.ru      password: 1 ");
        }
    }
}
