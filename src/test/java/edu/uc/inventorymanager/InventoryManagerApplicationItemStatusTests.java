package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.service.IItemStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryManagerApplicationItemStatusTests {

    @Autowired
    IItemStatusService itemStatusService;
    private ItemStatus itemStatus;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchItemStatusById_returnsItemStatusId5() {
        givenItemStatusDataAreAvailable();
        whenSearchItemStatusWithId5();
        thenReturnItemStatusForId5();
    }

    private void whenSearchItemStatusWithId5() {
        itemStatus = itemStatusService.fetchItemStatusById(5);
    }

    private void givenItemStatusDataAreAvailable() {
    }

    private void thenReturnItemStatusForId5() {
        String name = itemStatus.getItemStatusName();
        assertEquals("Test Name", name);
    }
}
