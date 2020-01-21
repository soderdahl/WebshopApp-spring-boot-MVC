package webshopapp.webshopapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import webshopapp.webshopapp.model.Customer;
import webshopapp.webshopapp.service.LoginCustomerService;

@Controller
public class CustomerController {

    @Autowired
    LoginCustomerService loginService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @GetMapping("/")
    String index(){
        return "index";
    }



    @GetMapping("/login")
    public String loginCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "Please login:");
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Customer customer, Model model) {
        if (loginService.login(customer.getUserName())) {
            model.addAttribute("userName",customer.getUserName());
            return "viewProducts";
        } else {
            model.addAttribute("message", "No such user, try again");
            return "login";
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
