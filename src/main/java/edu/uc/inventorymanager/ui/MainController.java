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
        List<User> users = userService.fetchALl();
        List<ItemStatus> statuses = itemStatusService.fetchALl();
        model.addAttribute("users", users);
        model.addAttribute("statuses", statuses);
        return "index";
    }

    /**
     * Handle the /about endpoint
     *
     * @return
     */
    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    /**
     * Handle the /item-page endpoint
     *
     * @return
     */
    @RequestMapping("/item-page")
    public String itemPage(Model model) {
        List<Item> items = itemService.fetchAll();
        model.addAttribute("items", items);
        return "itemPage";
    }

    /**
     * Handle the /item/{id} endpoint
     *
     * @return
     */
    @RequestMapping("/item/{id}")
    public String editItem(Model model, @PathVariable(value = "id", required = true) int id) {
        Item item = itemService.fetchItemById(id);
        model.addAttribute("item", item);
        List<User> users = userService.fetchALl();
        List<ItemStatus> statuses = itemStatusService.fetchALl();
        model.addAttribute("users", users);
        model.addAttribute("statuses", statuses);
        return "editItem";
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
    @PostMapping(value = "/save-item", consumes = "multipart/form-data")
    public String saveItem(Item item) {
        try {
            Item newItem = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            newItem = itemService.save(item);
        } catch (Exception e) {
            logger.error("Failed to save item", e);
        }
        return "redirect:/item-page";
    }

    @PostMapping(value = "/update-item", consumes = "multipart/form-data")
    public String updateItem(Item item) {
        try {
            Item updatedItem = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            updatedItem = itemService.save(item);
        } catch (Exception e) {
            logger.error("Failed to save item", e);
        }
        return "redirect:/item-page";
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
