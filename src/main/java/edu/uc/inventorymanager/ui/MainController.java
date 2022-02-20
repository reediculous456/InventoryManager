package edu.uc.inventorymanager.ui;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /**
     * Handle the / endpoint
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        Item item = new Item();
        item.setId(0);
        item.setName("Name");
        item.setDescription("Des");
        item.setLocation("locale");
        item.setAssigned_to(1);
        item.setStatus_id(0);
        model.addAttribute(item);
        return "index";
    }
    @GetMapping("/item")
    public String index() {
        return "index";
    }
}
