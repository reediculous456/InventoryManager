package edu.uc.inventorymanager.dao.seeds;

import edu.uc.inventorymanager.dao.ItemRepository;
import edu.uc.inventorymanager.dao.ItemStatusRepository;
import edu.uc.inventorymanager.dao.UserRepository;
import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemStatusRepository itemStatusRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadItemStatusData();
        loadItemData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user1 = new User("Jane Doe");
            User user2 = new User("John Smith");
            userRepository.save(user1);
            userRepository.save(user2);
        }
    }

    private void loadItemStatusData() {
        if (itemStatusRepository.count() == 0) {
            ItemStatus status1 = new ItemStatus("Available");
            ItemStatus status2 = new ItemStatus("Assigned");
            ItemStatus status3 = new ItemStatus("Disposed");

            itemStatusRepository.save(status1);
            itemStatusRepository.save(status2);
            itemStatusRepository.save(status3);
        }
    }

    private void loadItemData() {
        if (itemRepository.count() == 0) {
            User user = userRepository.findById(1).get();
            ItemStatus statusAvailable = itemStatusRepository.findById(1).get();
            ItemStatus statusAssigned = itemStatusRepository.findById(2).get();

            Item item1 = new Item("2018 Macbook Pro", "Space Gray 2018 Macbook Pro with 16 GB of RAM, 2TB of storage, and Intel i7");
            item1.setStatus(statusAvailable);

            Item item2 = new Item("Dell XPS 17", "Black Dell XPS 17 with 8GB of RAM, 1TB of storage, and Intel i5");
            item2.setLocation("Cubicle 42J");
            item2.setAssignee(user);
            item2.setStatus(statusAssigned);

            itemRepository.save(item1);
            itemRepository.save(item2);
        }
    }
}
