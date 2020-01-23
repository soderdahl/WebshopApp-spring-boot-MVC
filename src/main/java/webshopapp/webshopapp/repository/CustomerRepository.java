package webshopapp.webshopapp.repository;

import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByUserName(String userName);

}
