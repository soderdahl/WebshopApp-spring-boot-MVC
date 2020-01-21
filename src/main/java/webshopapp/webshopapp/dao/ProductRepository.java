package webshopapp.webshopapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webshopapp.webshopapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
