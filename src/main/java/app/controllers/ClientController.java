package app.controllers;

import app.entities.ClientsEntity;
import app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public String findAll(Model model) {
        List<ClientsEntity> clients = clientService.getAllClients();
        model.addAttribute("client", clients);
        return "client-page";
    }

    @RequestMapping(value = "/clients/CreateClient")
    public String createClient(Model model) {
        ClientsEntity clients = new ClientsEntity();
        model.addAttribute("client", clients);
        return "create-client";
    }

    @RequestMapping(value = "/clients/UpdateClient/{id}")
    public String updateClientPage(@PathVariable int id, Model model) {
        ClientsEntity clients = clientService.getClientById(id).orElse(null);
        model.addAttribute("client", clients);
        return "update-client";
    }

    @RequestMapping(value = "/clients/AddClient")
    public String addClient(@ModelAttribute("clients") ClientsEntity clients) {
        clientService.saveClient(clients);
        return "redirect:/clients/";
    }

    @RequestMapping(value = "/clients/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return "redirect:/clients/";
    }

    @PostMapping("/clients/UpdateClient/update/{id}")
    public String updateClient(@PathVariable int id,
                               @ModelAttribute("client") ClientsEntity client) {
        clientService.updateClientById(id, client);
        return "redirect:/clients/";
    }

}
