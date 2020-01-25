package webshopapp.webshopapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshopapp.webshopapp.component.ShoppingCart;
import webshopapp.webshopapp.domain.Customer;
import webshopapp.webshopapp.domain.OrderLine;
import webshopapp.webshopapp.domain.Orders;
import webshopapp.webshopapp.domain.Product;
import webshopapp.webshopapp.repository.CustomerRepository;
import webshopapp.webshopapp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShoppingService shoppingService;

    @Autowired
    ShoppingCart shoppingCart;
/**
    public synchronized Orders createOrder(ShoppingCart shoppingCart, int id, Customer customer) {

    }
 */


   /* public boolean checkout(Integer id, List<Product> basket) {
        Optional<Customer> customerOptional = getOne(id);
        AtomicBoolean everythingWentOkay = new AtomicBoolean(true);
        // Borde ändra logiken till CustomerService...
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Orders customerOrder = new Orders();
            customerOrder.setCustomer(customer);
            Optional<Orders> optionalOrder = Optional.of(orderRepository.saveAndFlush(customerOrder));
            if (optionalOrder.isPresent()) {
                basket.forEach(article -> {
                    OrderLine orderLine = new OrderLine(article, customerOrder, article.getQuantity());
                    Optional<OrderLine> optionalOrderLine = Optional.of(orderLineRepository.saveAndFlush(orderLine));
                    if(optionalOrderLine.isPresent()){
                        customerOrder.getOrderlines().add(orderLine);
                    } else {
                        everythingWentOkay.set(false);
                    }
                });
                customer.getOrders().add(customerOrder);
                Optional<Customer> updatedCustomer = update(id, customer);
                if (updatedCustomer.isPresent()) {
                    Optional<Order> updatedOrder = orderService.update(optionalOrder.get().getId(), customerOrder);
                    if(updatedOrder.isPresent() && everythingWentOkay.get()) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }*/

    private Optional<Customer> getOne(Integer id) {
        return customerRepository.findById(id);
    }
}
