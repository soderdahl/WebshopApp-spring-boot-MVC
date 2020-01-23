package webshopapp.webshopapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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








}
