package webshopapp.webshopapp.repository;


import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
