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

    /**
     * Handle the / endpoint
     *
     * @return
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

    @GetMapping("/items")
    @ResponseBody
    public List<Item> fetchAllItems() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return itemService.fetchAll();
    }
}
