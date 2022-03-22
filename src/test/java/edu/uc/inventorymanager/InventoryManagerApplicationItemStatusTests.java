package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dao.IItemStatusDAO;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.service.IItemStatusService;
import edu.uc.inventorymanager.service.ItemStatusService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryManagerApplicationItemStatusTests {

    IItemStatusService itemStatusService;
    private ItemStatus itemStatus;

    @MockBean
    private IItemStatusDAO itemStatusDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchItemStatusById_returnsItemStatusId1() throws Exception {
        givenItemStatusDataAreAvailable();
        whenSearchItemStatusWithId1();
        thenReturnItemStatusForId1();
    }

    private void whenSearchItemStatusWithId1() {
        ItemStatus status = new ItemStatus("Default");
        status.setId(1);
        Mockito.when(itemStatusDAO.fetchById(1)).thenReturn(status);
        itemStatus = itemStatusService.fetchItemStatusById(1);
    }

    private void givenItemStatusDataAreAvailable() throws Exception {
        Mockito.when(itemStatusDAO.save(itemStatus)).thenReturn(itemStatus);
        itemStatusService = new ItemStatusService(itemStatusDAO);
    }

    private void thenReturnItemStatusForId1() {
        String name = itemStatus.getName();
        assertEquals("Default", name);
    }
}
