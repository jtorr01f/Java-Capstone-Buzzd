package app.services;

import app.entities.InventoryEntity;
import app.repos.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    public InventoryRepository inventoryRepository;

    public List<InventoryEntity> getAllInventory() {
        List<InventoryEntity> inventory = new ArrayList<InventoryEntity>();
        inventoryRepository.findAll().forEach(inventory::add);
        return inventory;
    }

    public Optional<InventoryEntity> getInventoryById(int id) {
        return inventoryRepository.findById(id);
    }

    public void updateInventoryById(int id, InventoryEntity inventory) {
        inventoryRepository.save(inventory);
    }

    public void deleteInventory(int id) {
        inventoryRepository.deleteById(id);
    }

    public void saveInventory(InventoryEntity inventory) {
        inventoryRepository.save(inventory);
    }
}
