package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleDao roleDao;

    @Autowired
    public DataInitializer(UserService userService, RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleDao.save(role1);
        roleDao.save(role2);

        Set<Role> roleAdmin = new HashSet<>();
        Set<Role> roleUser = new HashSet<>();

        roleAdmin.add(role1);
        roleUser.add(role2);

        User user1 = new User("admin", "admin", "admin@gmail.com",roleAdmin);
        User user2 = new User("user2", "user2",  "user2@gmail.com", roleUser);
        User user3 = new User("user3", "user3",  "user3@gmail.com", roleUser);
        User user4 = new User("user4", "user4",  "user4@gmail.com", roleUser);
        User user5 = new User("user5", "user5",  "user5@gmail.com", roleUser);
        User user6 = new User("user6", "user6",  "user6@gmail.com", roleUser);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);
        userService.addUser(user6);
    }
}
