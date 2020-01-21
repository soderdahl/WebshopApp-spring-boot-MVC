package webshopapp.webshopapp.component;

import webshopapp.webshopapp.model.Product;


public class Item {

    private int count;

    private Product product;

    public Item() {
    }

    public Item(Product product, int count) {
        this.product = product;
        this.count = count;
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
