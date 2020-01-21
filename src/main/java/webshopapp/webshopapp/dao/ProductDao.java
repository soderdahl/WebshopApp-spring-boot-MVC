package webshopapp.webshopapp.dao;

import webshopapp.webshopapp.domain.Product;

import java.util.List;

public interface ProductDao {


    void addProduct(int productId, String productName, double price);

    void editProduct(int productId);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}
