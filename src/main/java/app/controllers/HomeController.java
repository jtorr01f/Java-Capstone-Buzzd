package app.controllers;

import app.entities.AppointmentsEntity;
import app.entities.ClientsEntity;
import app.services.AppointmentService;
import app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="/home")
    public String home(Model model){

        List<ClientsEntity> clients = clientService.getAllClients();
        model.addAttribute("client", clients);

        List<AppointmentsEntity> appointment = appointmentService.getAllAppointments();
        model.addAttribute("appointment", appointment);

        return "home-page";
    }

    @RequestMapping(value="/")
    public String homeRedirect(){
        return "redirect:home";
    }
}
