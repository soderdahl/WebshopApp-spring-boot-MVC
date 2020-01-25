package webshopapp.webshopapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webshopapp.webshopapp.service.ProductService;
import webshopapp.webshopapp.domain.Product;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/webShop")
public class ShopRestController {

    @Autowired
    ProductService productService;

    /*add a product*/
    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);

    }

    /*get all products*/
    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productService.findAllProduct();

    }

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products", products);

        return "productList";
    }

    /*get one product by productId*/
    @GetMapping("/getOneProduct/{productId}")
    public ResponseEntity<Optional<Product>> getOneProduct(@PathVariable(value = "productId") int productId) {
       Optional<Product> product = productService.findProductById(productId);

       if (product==null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok().body(product);
    }


    /*update a product*/
    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.editProduct(product);
    }

    /*update a product by productId*/
   /* @PutMapping("/editProduct/{productId}")*/
    public ResponseEntity<Optional<Product>> editProduct(@PathVariable(value = "productId") Integer productId, @Valid @RequestBody Product productDetails) {

        Optional<Product> product = productService.findProductById(productId);

        if (product==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(product);//"updateProduct" instead

    }

    /*delete a product*/
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Optional<Product>> deleteProduct(@PathVariable(value = "productId") Integer productId) {

        Optional<Product> product = productService.findProductById(productId);

        if (product==null) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProductById(productId);

        return ResponseEntity.ok().build();
    }



}




