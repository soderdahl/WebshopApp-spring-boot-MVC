package webshopapp.webshopapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.dao.CustomerRepository;
import webshopapp.webshopapp.model.Customer;

import java.util.List;

@Service
@SessionScope
public class LoginCustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;
    boolean isLoggedIn;

    Logger logger = LoggerFactory.getLogger(LoginCustomerService.class);

    public LoginCustomerService() {
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
}
