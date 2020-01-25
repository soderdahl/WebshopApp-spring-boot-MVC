package webshopapp.webshopapp.component;

import webshopapp.webshopapp.domain.Product;


public class Item {

    private int count=1;

    private Product product;

    public Item() {
    }

    public Item(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
