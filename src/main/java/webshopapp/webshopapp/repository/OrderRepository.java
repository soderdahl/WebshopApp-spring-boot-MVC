package webshopapp.webshopapp.repository;

import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}

