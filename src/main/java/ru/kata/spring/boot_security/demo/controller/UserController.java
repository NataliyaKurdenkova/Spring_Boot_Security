package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.EntityService;

import java.util.Optional;

@Controller
public class UserController {
    private final EntityService<User> userService;
    private final EntityService<Role> roleService;

    @Autowired
    public UserController(EntityService<User> userService, EntityService<Role> roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String showInfoUsers(ModelMap model) {
        Optional<User> user = userService.findByName(getCurrentUsername());
        //model.addAttribute("roles", user.get().getRoles());
        model.addAttribute("users", user.get());
        return "user";
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return auth.getName();
    }

}
