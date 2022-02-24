package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    /*
    @RequestMapping("/")
    public String index() {return "index";}

     */


    @RequestMapping("/")
    public String index(Model model) {
        Item item = new Item();
        item.setName("name");
        item.setDescription("Des");
        item.setLocation("locale");
        item.setAssignedTo(1);
        item.setStatusId(0);
        item.setId(1);

        model.addAttribute(item);
        return "index";
    }


    @RequestMapping("/saveItem")
    public String saveItem(Item item) {
        try {
            itemService.save(item);
        } catch (Exception e){
            e.printStackTrace();
            return "index";
        }
       // itemService.save(item);
        return "index";
    }
/*
    @RequestMapping("/error")
    public String errorPage(){
        return "index";
    }
*/

    @GetMapping("/item")
    @ResponseBody
    public List<Item> fetchAllItems() {
        return itemService.fetchAll();
    }





    @PostMapping(value ="/item", consumes="application/json", produces = "application/json")
    @ResponseBody
    public Item createItem(@RequestBody Item item){
        Item newItem = null;
        try {
            newItem = itemService.save(item);
        } catch (Exception e){
            //
        }
        return newItem;
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
    /*
    @GetMapping("/item/{id}")
    public ResponseEntity fetchItemById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
*/

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
    /*
      @GetMapping("/user/{id}")
      public ResponseEntity fetchUserById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
    */

}
