package app.controllers;

import app.entities.UserEntity;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String findAll(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-page";
    }
    @RequestMapping(value = "/users/CreateUser")
    public String createUser(Model model) {
        UserEntity users = new UserEntity();
        model.addAttribute("users",users);
        return "new-user";
    }
    @RequestMapping(value = "/users/addUser")
    public String addClient(@ModelAttribute("users") UserEntity user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }
    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users/save/{id}")
    public String updateUser(@PathVariable int id,
                               @ModelAttribute("users") UserEntity user) {
        userService.updateUserById(id, user);
        return "redirect:/users/";
    }

}
