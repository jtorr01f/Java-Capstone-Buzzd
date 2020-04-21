package app.controllers;

import app.entities.UserEntity;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String findAll(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("user", users);
        return "user-page";
    }
    @RequestMapping(value = "/users/CreateUser")
    public String createUser(Model model) {
        UserEntity users = new UserEntity();
        model.addAttribute("user",users);
        return "new-user";
    }
    @RequestMapping(value = "/users/addUser")
    public String addUser(@ModelAttribute("user") UserEntity user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }
    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users/save/{id}")
    public String updateUser(@PathVariable int id,
                               @ModelAttribute("user") UserEntity user) {
        userService.updateUserById(id, user);
        return "redirect:/users/";
    }
}
