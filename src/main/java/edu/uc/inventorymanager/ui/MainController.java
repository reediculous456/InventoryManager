package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    IItemService itemService;

    /**
     * Handle the / endpoint
     *
     * @return index
     */
    @RequestMapping("/")
    public String index(Model model) {
        Item item = new Item("item", "Des");
        item.setLocation("locale");
        item.setAssignee(new User("John Doe"));
        item.setStatus(new ItemStatus("Assigned"));
        model.addAttribute(item);
        return "index";
    }

    @RequestMapping("/saveItem")
    public String saveItem(Item item) throws Exception {
        itemService.save(item);
        return "index";
    }

    @GetMapping("/item")
    @ResponseBody
    public List<Item> fetchAllItems() {
        return itemService.fetchAll();
    }


    /**
     * Fetch item with given ID
     * <p>
     * Given the parameter id, find an item that corresponds to this unique id.
     * <p>
     * Returns one of the following status codes:
     * 200: item found
     * 400: item not found
     *
     * @param id
     * @return ResponseEntity(HttpStatus.OK)
     */
    @GetMapping("/item/{id}")
    public ResponseEntity fetchItemById(@PathVariable("id") String id) { return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Fetch user with given ID
     * <p>
     * Given the parameter id, find an user that corresponds to this unique id.
     * <p>
     * Returns one of the following status codes:
     * 200: user found
     * 400: user not found
     *
     * @param id
     * @return ResponseEntity(HttpStatus.OK)
     */
    @GetMapping("/user/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
