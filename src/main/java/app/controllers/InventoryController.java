package app.controllers;

import app.entities.ClientsEntity;
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
        return "create-inventory";
    }

    @RequestMapping(value = "/inventory/UpdateInventory/{id}")
    public String updateInventoryPage(@PathVariable int id, Model model) {
        InventoryEntity inventory = inventoryService.getInventoryById(id).orElse(null);
        model.addAttribute("inventory", inventory);
        return "update-inventory";
    }

    @RequestMapping(value = "/inventory/AddInventory")
    public String addInventory(@ModelAttribute("inventory") InventoryEntity inventory) {
        inventoryService.saveInventory(inventory);
        return "redirect:/inventory/";
    }

    @RequestMapping(value = "/inventory/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventory/";
    }

    @PostMapping("/inventory/UpdateInventory/update/{id}")
    public String updateInvetory(@PathVariable int id,
                                 @ModelAttribute("inventory") InventoryEntity inventory) {
        inventoryService.updateInventoryById(id, inventory);
        return "redirect:/inventory/";
    }

}
