package webshopapp.webshopapp.repository;

import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.OrderProducts;

public interface OrderProductsRepository extends CrudRepository<OrderProducts, Integer> {
}
