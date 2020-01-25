package webshopapp.webshopapp.repository;


import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.Product;


import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> findByProductName(String productName);

}
