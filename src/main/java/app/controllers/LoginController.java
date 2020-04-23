/*
package app.controllers;

import app.entities.UserEntity;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String findAll(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("user", users);
        return "login-page";
    }
}
*/
