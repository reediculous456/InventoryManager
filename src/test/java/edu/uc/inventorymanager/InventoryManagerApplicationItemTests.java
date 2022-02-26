package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.service.IItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InventoryManagerApplicationItemTests {

    @Autowired
    IItemService itemService;
    private Item item;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchItemById_returnsItemId5() {
        givenItemDataAreAvailable();
        whenSearchItemWithId5();
        thenReturnItemForId5();
    }

    private void whenSearchItemWithId5() {
        item = itemService.fetchItemById(5);
    }

    private void givenItemDataAreAvailable() {
    }

    private void thenReturnItemForId5() {
        String description = item.getItemDescription();
        assertEquals("Test Description", description);
    }
}
