package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
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
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Item item = new Item(0, "item");
        item.setItemDescription("Des");
        item.setItemLocation("locale");
        item.setAssignedTo(1);
        item.setStatusId(0);
        model.addAttribute(item);
        return "index";
    }


    @RequestMapping("/saveItem")
    public String saveItem(Item item) {
        //itemService.save(item);
        return "index";
    }

    @GetMapping("/item")
    @ResponseBody
    public List<Item> fetchAllItems() {
        return itemService.fetchAll();
    }

    /*
    @PostMapping(value ="/item", consumes="application/json", produces = "application/json")
    @ResponseBody
    public Item createItem(@ResponseBody Item item){
        Item newItem = null;
        try {
            //newItem = itemService.save(item);
        } catch (Exception e){
            //
        }
    }
     */

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
