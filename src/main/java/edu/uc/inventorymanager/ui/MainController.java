package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IItemService;
import edu.uc.inventorymanager.service.IItemStatusService;
import edu.uc.inventorymanager.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    IItemService itemService;

    @Autowired
    IUserService userService;

    @Autowired
    IItemStatusService itemStatusService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle the / endpoint
     *
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Item newItem = new Item();
        model.addAttribute("newItem", newItem);
        List<Item> items = itemService.fetchAll();
        List<User> users = userService.fetchALl();
        List<ItemStatus> statuses = itemStatusService.fetchALl();
        model.addAttribute("items", items);
        model.addAttribute("users", users);
        model.addAttribute("statuses", statuses);
        return "index";
    }

    /**
     * Saves an Item and components within an item
     * <p>
     * Returns one of the following status codes
     * 201: Item Saved
     * 500: error saving item
     *
     * @param item
     * @return response code
     */
    @PostMapping(value = "/save-item", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity saveItem(Item item) {
        try {
            Item newItem = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            newItem = itemService.save(item);
            return new ResponseEntity(newItem, headers, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to save item", e);
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }

    /**
     * Fetches all of the Items that have been created
     * <p>
     * Returns one of the following status codes
     * 200: Fetched all saved items
     * 400: error fetching all items
     *
     * @return
     */
    @GetMapping("/items")
    @ResponseBody
    public List<Item> fetchAllItems() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return itemService.fetchAll();
    }

    /**
     * Fetch item with given ID
     * <p>
     * Given the parameter id, find an item that corresponds to this unique id.
     * <p>
     * Returns one of the following status codes:
     * 200: item found
     * 404: item not found
     *
     * @param id
     * @return
     */
    @GetMapping("/item/{id}")
    public ResponseEntity fetchItemById(@PathVariable("id") int id) {
        var item = itemService.fetchItemById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Fetch user with given ID
     * <p>
     * Given the parameter id, find a user that corresponds to this unique id.
     * <p>
     * Returns one of the following status codes:
     * 200: user found
     * 404: user not found
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") int id) {
        var user = userService.fetchUserById(id);
        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
