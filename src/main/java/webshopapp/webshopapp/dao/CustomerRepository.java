package webshopapp.webshopapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webshopapp.webshopapp.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByUserName(String userName);

}
