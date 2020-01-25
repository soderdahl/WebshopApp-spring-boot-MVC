package webshopapp.webshopapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.component.Item;
import webshopapp.webshopapp.component.ShoppingCart;
import webshopapp.webshopapp.domain.*;
import webshopapp.webshopapp.repository.OrderProductsRepository;
import webshopapp.webshopapp.repository.OrderRepository;
import webshopapp.webshopapp.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    ShoppingCart cart;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductsRepository orderProductsRepository;


    @PostMapping("/checkout")
    public String checkout(HttpSession session,Model model){
        Orders order = createNewOrder(session);
        addProductsFromShoppingCartToOrder(order);
        model.addAttribute("orders",orderRepository.findAll());
        model.addAttribute("ordersProducts",orderProductsRepository.findAll());
        model.addAttribute("sum",cart.getTotalCost());
        return "order";
    }

    public Orders createNewOrder(HttpSession session){
        Orders order = new Orders();

        Customer customer = (Customer)session.getAttribute("customer");
        order.setCustomer(customer);
        orderRepository.save(order);
        return order;
    }
    public void addProductsFromShoppingCartToOrder(Orders order){
        for (Item item: cart.getItems()){
            OrderProducts orderProduct = new OrderProducts();
            orderProduct.setOrders(order);
            orderProduct.setProduct(item.getProduct());
            orderProductsRepository.save(orderProduct);
        }
    }

}
