package webshopapp.webshopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshopapp.webshopapp.domain.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByUserName(String userName);

}
