package app.controllers;

import app.entities.InventoryEntity;
import app.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/inventory")
    public String findAll(Model model) {
        List<InventoryEntity> inventory = inventoryService.getAllInventory();
        model.addAttribute("inventory", inventory);
        return "inventory-page";
    }
    @RequestMapping(value = "/inventory/CreateInventory")
    public String createInventory(Model model) {
        InventoryEntity inventory = new InventoryEntity();
        model.addAttribute("inventory", inventory);
        return "new-inventory";
    }
    @RequestMapping(value = "/inventory/addInventory")
    public String addInventory(@ModelAttribute("inventory") InventoryEntity inventory) {
        inventoryService.saveInventory(inventory);
        return "redirect:/inventory/";
    }
    @RequestMapping(value = "/inventory/delete/{id}", method = RequestMethod.DELETE)
    public void deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }

    @PostMapping("/clients/save/{id}")
    public String updateInvetory(@PathVariable int id,
                               @ModelAttribute("inventory") InventoryEntity inventory) {
        inventoryService.updateInventoryById(id, inventory);
        return "redirect:/inventory/";
    }

}
