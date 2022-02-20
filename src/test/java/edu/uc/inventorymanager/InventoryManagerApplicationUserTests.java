package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryManagerApplicationUserTests {

    @Autowired
    IUserService userService;
    private User user;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchUserById_returnsUserId5() {
        givenUserDataAreAvailable();
        whenSearchUserWithId5();
        thenReturnUserForId5();
    }

    private void whenSearchUserWithId5() {
        user = userService.fetchUserById(5);
    }

    private void givenUserDataAreAvailable() {
    }

    private void thenReturnUserForId5() {
        String name = user.getName();
        assertEquals("Test Name", name);
    }
}
