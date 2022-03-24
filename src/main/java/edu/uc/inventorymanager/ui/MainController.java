package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class MainController {

    static final String USER_NAME = "John Doe";
    static final String DESCRIPTION = "Des";

    @Autowired
    IItemService itemService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle the / endpoint
     *
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Item item = new Item("item", DESCRIPTION);
        item.setLocation("locale");
        item.setAssignee(new User(USER_NAME));
        item.setStatus(new ItemStatus("Assigned"));
        model.addAttribute(item);
        return "index";
    }

    @RequestMapping("/saveItem")
    public String saveItem(Item item) {
        try {
            itemService.save(item);
        }catch (Exception e){
            log.error("Unable to Save!");
        }
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
     * @return
     */
    @GetMapping("/item/{id}")
    public ResponseEntity fetchItemById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
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
     * @return
     */
    @GetMapping("/user/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
