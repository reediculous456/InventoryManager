package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dao.IItemDAO;
import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.service.IItemService;
import edu.uc.inventorymanager.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InventoryManagerApplicationItemTests {

    IItemService itemService;
    private Item item;

    @MockBean
    private IItemDAO itemDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchItemById_returnsItemId5() throws Exception {
        givenItemDataAreAvailable();
        whenSearchItemWithId5();
        thenReturnItemForId5();
    }

    private void whenSearchItemWithId5() {
        Item item = new Item();
        item.setId(5);
        item.setDescription("Test Description");
        Mockito.when(itemDAO.fetchById(5)).thenReturn(item);
        this.item = itemService.fetchItemById(5);
    }

    private void givenItemDataAreAvailable() throws Exception {
        Mockito.when(itemDAO.save(item)).thenReturn(item);
        itemService = new ItemService(itemDAO);
    }

    private void thenReturnItemForId5() {
        String description = item.getDescription();
        assertEquals("Test Description", description);
    }
}
