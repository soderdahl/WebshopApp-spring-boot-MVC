package webshopapp.webshopapp.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.domain.Customer;
import webshopapp.webshopapp.domain.Product;

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

    public void addItem(Product product) {
        Item exists=null;
        if (items.isEmpty()){
            Item item = new Item(product);
            items.add(item);
            System.out.println("Item was added");
        }
        else{
            for (Item itemFromList: items){
                if(itemFromList.getProduct().getProductId()==product.getProductId()) {
                    exists = itemFromList;
                }
            }
            if (exists!=null){
                System.out.println("Item exists");
                exists.setCount(exists.getCount()+1);
            }
             else {
            System.out.println("Item is not exists");
            Item item = new Item(product);
            items.add(item);
            System.out.println("Item was added");
        }
        }

    }

    public int getTotalCost() {
        int totalCost =0;
        for (Item item:items ) {
            totalCost+= item.getProduct().getPrice()* item.getCount();
        }
        return totalCost;
    }

    public void decreaseItem(Product product) {
        for (Item item:items) {
            if(item.getProduct().equals(product)){
                if (item.getCount() ==1) {
                    items.remove(item);
                }
                else {
                    item.setCount(item.getCount()-1);
                }
            }
        }

    }

}
