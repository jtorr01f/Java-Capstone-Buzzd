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
        return "new-client";
    }
    @RequestMapping(value = "/clients/addClient")
    public String addClient(@ModelAttribute("clients") ClientsEntity clients) {
        clientService.saveClient(clients);
        return "redirect:/clients/";
    }
    @RequestMapping(value = "/clients/delete/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }

    @PostMapping("/clients/save/{id}")
    public String updateClient(@PathVariable int client_id,
                            @ModelAttribute("client") ClientsEntity client) {
        clientService.updateClientById(client_id, client);
        return "redirect:/clients/";
    }

}
