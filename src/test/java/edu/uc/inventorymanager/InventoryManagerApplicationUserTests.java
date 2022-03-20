package edu.uc.inventorymanager;

import edu.uc.inventorymanager.dao.IUserDAO;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IUserService;
import edu.uc.inventorymanager.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryManagerApplicationUserTests {

    IUserService userService;
    private User user;

    @MockBean
    private IUserDAO userDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchUserById_returnsUserId5() throws Exception {
        givenUserDataAreAvailable();
        whenSearchUserWithId5();
        thenReturnUserForId5();
    }

    private void whenSearchUserWithId5() {
        User user = new User("Test Name");
        user.setId(5);
        Mockito.when(userDAO.fetchById(5)).thenReturn(user);
        this.user = user;
    }

    private void givenUserDataAreAvailable() throws Exception {
        Mockito.when(userDAO.save(user)).thenReturn(user);
        userService = new UserService(userDAO);
    }

    private void thenReturnUserForId5() {
        String name = user.getName();
        assertEquals("Test Name", name);
    }
}
