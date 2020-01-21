package webshopapp.webshopapp.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDaoImpl {

    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(int productId) {
        return productRepository.findById(productId);
    }

    public Product editProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }


}
