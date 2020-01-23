package webshopapp.webshopapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webshopapp.webshopapp.domain.Customer;
import webshopapp.webshopapp.domain.CustomerLoginFormBean;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.service.CustomerService;
import webshopapp.webshopapp.service.ProductService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;



    @GetMapping("/")
    String index(){
        return "index";
    }

    @PostMapping("/addNewCustomer")
    public String addNewCustomer(@ModelAttribute Customer customer, Model model) {

        if (customerService.addCustomer(customer.getUserName())) {
            model.addAttribute("userName",customer.getUserName());
            return "viewProducts";
        } else {
            model.addAttribute("message", "Please try again");
            return "addNewCustomer";
        }
    }

    @GetMapping("/login")
    public String loginCustomer(Model model) {
        model.addAttribute("loginCustomerForm", new CustomerLoginFormBean());
        model.addAttribute("message", "Please login:");
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute CustomerLoginFormBean loginCustomerForm, Model model) {
        if (customerService.login(loginCustomerForm.getUserName())) {
            model.addAttribute("userName",loginCustomerForm.getUserName());
            return "redirect:/viewProducts";
        } else {
            model.addAttribute("message", "No user with name "+loginCustomerForm.getUserName()+", try again");
            return "index";
        }
    }



    @RequestMapping("/viewProducts")
    public String getProducts(Model model) {
        List<Product> products = productService.findAllProduct();
        System.out.println(products);
        model.addAttribute("products", products);

        return "viewProducts";
    }


    @GetMapping("/shoppingCart")
    String shoppingCart(){
        return "shoppingCart";
    }


}
