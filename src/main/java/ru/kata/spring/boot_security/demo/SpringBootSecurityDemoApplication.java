package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.EntityService;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {


    public static EntityService<User> userService;

    public static EntityService<Role> roleService;

    @Autowired
    public SpringBootSecurityDemoApplication(EntityService<User> userService, EntityService<Role> roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
        startValue();
    }

    public static void startValue() {
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        roleService.save(adminRole);
        roleService.save(userRole);

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        User adminUser = new User("admin", "admin", "admin@mail", "admin", roles);
        userService.save(adminUser);
    }

}
