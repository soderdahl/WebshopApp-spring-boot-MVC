package webshopapp.webshopapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import webshopapp.webshopapp.domain.CustomerLoginFormBean;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "adminProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        productService.addProduct(product);
        return "adminProduct";
    }

    @PostMapping("/searchProduct")
    public String searchProduct(@RequestParam String keyword, Model model) {
        Optional<Product> searchProduct = productService.findProductByName(keyword);
        if (searchProduct.isPresent()) {
            model.addAttribute("searchProduct", searchProduct.get());
            return "searchProduct";
        } else {
            model.addAttribute("message", "The product with name " + keyword + " is does not found, try again");
            return "searchProduct";

        }
    }
}