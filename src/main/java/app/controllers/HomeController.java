package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="/home")
    public String home(){
        return "home-page";
    }

    @RequestMapping(value="/")
    public String homeRedirect(){
        return "redirect:home-page";
    }
}
