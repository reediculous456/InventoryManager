package edu.uc.inventorymanager.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /**
     * Handle the / endpoint
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
