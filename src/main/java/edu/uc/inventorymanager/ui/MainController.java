package edu.uc.inventorymanager.ui;


import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.ItemStatus;
import edu.uc.inventorymanager.dto.User;
import edu.uc.inventorymanager.service.IItemService;
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

    /**
     * Saves an Item and components within an item
     *
     * Returns one of the following status codes
     * 200: Item Saved
     * 400: error saving item
     * @param item
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveItem")
    public String saveItem(Item item) throws Exception {
        itemService.save(item);
        return "index";
    }

    /**
     * Fetches all of the Items that have been created
     *
     * Returns one of the following status codes
     * 200: Fetched all saved items
     * 400: error fetching all items
     * @return
     */
    @GetMapping("/items")
    @ResponseBody
    public List<Item> fetchAllItems() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return itemService.fetchAll();
    }
}
