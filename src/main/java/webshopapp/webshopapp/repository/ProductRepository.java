package webshopapp.webshopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshopapp.webshopapp.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
