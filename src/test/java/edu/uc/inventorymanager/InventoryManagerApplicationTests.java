package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.service.IItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InventoryManagerApplicationTests {

    @Autowired
    IItemService itemService;
    private Item item;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchItemByID_returnsItemID5(){
        givenItemDataAreAvailable();
        whenSearchItemWithId5();
        thenReturnItemForId5();
    }

    private void whenSearchItemWithId5() {
        item = itemService.fetch(5);
    }

    private void givenItemDataAreAvailable() {
    }

    private void thenReturnItemForId5() {
        String description = item.getDescription();
        assertEquals("Test Description", description);
    }
}
