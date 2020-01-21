package webshopapp.webshopapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import webshopapp.webshopapp.model.Admin;
import webshopapp.webshopapp.service.LoginAdminService;
import webshopapp.webshopapp.service.LoginCustomerService;

@Controller
public class AdminController {

    @Autowired
    LoginAdminService loginAdminService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);


    @GetMapping("/")
    String index(){
        return "index";
    }



    @GetMapping("/loginAdmin")
    public String loginAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        model.addAttribute("message", "Please login:");
        return "loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String loginSubmit(@ModelAttribute Admin admin, Model model) {
        if (loginAdminService.login(admin.getUserName())) {
            model.addAttribute("userName",admin.getUserName());
            return "viewProducts";
        } else {
            model.addAttribute("message", "No such user, try again");
            return "loginAdmin";
        }
    }

    @GetMapping("/viewProducts")
    String viewProducts(){
        return "viewProducts";
    }


    @GetMapping("/shoppingCart")
    String shoppingCart(){
        return "shoppingCart";
    }
}
