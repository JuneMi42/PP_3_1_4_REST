package ru.kata.spring.boot_security.demo.Service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService{

    private final UserRepository userDao;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserServiceImp(UserRepository userDao, RoleRepository roleRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }



    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }


    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        if(updateUser.getRoles().isEmpty()) {
            Set<Role> roleSet = getUserById(id).getRoles();
            updateUser.setRoles(roleSet);
        }
        if (updateUser.getPassword().isEmpty()) {
            updateUser.setPassword(userDao.getById(id).getPassword());
        } else {
            updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        }
        updateUser.setId(id);
        userDao.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);
    }
}
