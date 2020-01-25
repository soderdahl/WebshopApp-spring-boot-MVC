package webshopapp.webshopapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.repository.OrderRepository;

@Service
@SessionScope
public class ShoppingService {

    @Autowired
    OrderRepository orderRepository;
}
