package edu.uc.inventorymanager.ui;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        item.setName("item");
        item.setDescription("Des");
        item.setLocation("locale");
        item.setAssigned_to(1);
        item.setStatus_id(0);
        model.addAttribute(item);
        return "index";
    }

    @RequestMapping("saveItem")
    public String saveItem(Item item){
        //itemService.save(item);
        return "index";
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
    @GetMapping("/item")
    public String index() {
        return "index";
    }
}
