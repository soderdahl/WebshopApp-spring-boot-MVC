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
import webshopapp.webshopapp.component.ShoppingCart;
import webshopapp.webshopapp.domain.Customer;
import webshopapp.webshopapp.domain.CustomerLoginFormBean;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.repository.CustomerRepository;
import webshopapp.webshopapp.service.CustomerService;
import webshopapp.webshopapp.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShoppingCart cart;



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

    @GetMapping("/logout")
    public String logout(Model model){
        cart.getItems().clear();
        return "index";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute CustomerLoginFormBean loginCustomerForm, HttpSession session, Model model) {
        if (customerService.login(loginCustomerForm.getUserName())) {
            model.addAttribute("userName",loginCustomerForm.getUserName());
            List<Customer> customers = customerRepository.findByUserName(loginCustomerForm.getUserName());
            Customer customer = customers.get(0);
            session.setAttribute("customer",customer);
            return "redirect:/viewProducts";
        } else {
            model.addAttribute("message", "No user with name "+loginCustomerForm.getUserName()+", try again");
            return "index";
        }
    }



    @RequestMapping("/viewProducts")
    public String getProducts(Model model) {
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("sum",cart.getTotalCost());
        return "viewProducts";
    }


    @GetMapping("/shoppingCart")
    String shoppingCart(){
        return "shoppingCart";
    }


}
