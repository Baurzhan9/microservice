package com.example.course.controller;

import com.example.course.model.User;
import com.example.course.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/sign-up"})
    public String sign(Model model, HttpServletRequest request) {

        return "sign";
    }

    @GetMapping(value = {"/sign-in"})
    public String log(Model model, HttpServletRequest request) {

        return "login";
    }

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword() == password) {
            return "courses";
        } else {
            return "login";
        }
    }

}
