package webshopapp.webshopapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.repository.CustomerRepository;
import webshopapp.webshopapp.domain.Customer;

import java.util.List;

@Service
@SessionScope
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;
    boolean isLoggedIn;



    public CustomerService() {
    }

    public boolean login(String userName) {
        List<Customer> customerList = customerRepository.findByUserName(userName);
        if (customerList.size()>0) {
            customer = customerList.get(0);
            isLoggedIn = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String userName) {
        List<Customer> customerListList = customerRepository.findByUserName(userName);
        if (customerListList.size()>0) {
            return false;
        } else {
            customerRepository.save(new Customer(userName));
            return true;
        }
    }

}
