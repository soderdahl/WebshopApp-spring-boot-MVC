package webshopapp.webshopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webshopapp.webshopapp.component.ShoppingCart;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.service.ProductService;


@Controller
@RequestMapping("/shoppingCart")
public class ShoppingController {

    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCart cart;


    @PostMapping("/add")
    public String addToCart(@RequestParam int id, Model model ){
        Product product = productService.findProductById(id).get();
        cart.addItem(product);
        model.addAttribute("cartList",cart.getItems());
        model.addAttribute("sum",cart.getTotalCost());
        return "shoppingCart";
    }

    @PostMapping("/decrease")
    public String decreaseFromCart(@RequestParam int id, Model model ){
        Product product = productService.findProductById(id).get();
        cart.decreaseItem(product);
        model.addAttribute("cartList",cart.getItems());
        model.addAttribute("sum",cart.getTotalCost());
        return "shoppingCart";
    }

}
