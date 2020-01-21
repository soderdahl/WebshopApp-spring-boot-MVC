package webshopapp.webshopapp.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class ShoppingCart {

    List<Item> items = new ArrayList<>();

    private Customer customer;

    public ShoppingCart() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(items.contains(item)){
            item.setCount(item.getCount()+1);
        } else {
            item.setCount(item.getCount()+1);
            items.add(item);
        }
    }

    public int getTotalCost() {
        int totalCost =0;
        for (Item item:items ) {
            totalCost+= item.getProduct().getPrice()* item.getCount();
        }
        return totalCost;
    }

    public void deleteItem(Item item) {
        if(items.contains(item)){
            item.setCount(item.getCount()-1);

            if (item.getCount() ==0) {
                items.remove(item);
            }
        }
    }

}
