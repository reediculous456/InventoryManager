package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IItemService;
import edu.uc.inventorymanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    IItemService itemService;
  
    @Autowired
    IUserService userService;

    /**
     * Handle the / endpoint
     *
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Item newItem = new Item();
        newItem.setLocation("locale");
        newItem.setAssignee(new User("John Doe"));
        newItem.setStatus(new ItemStatus("Assigned"));
        model.addAttribute("newItem", newItem);
        List<Item> items = itemService.fetchAll();
        model.addAttribute("items", items);
        return "index";
    }

    @RequestMapping("/saveItem")
    public String saveItem(Item item) throws Exception {
        itemService.save(item);
        return "index";
    }

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
