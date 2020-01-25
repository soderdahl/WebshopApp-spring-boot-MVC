package webshopapp.webshopapp.domain;

import javax.persistence.*;

@Entity
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    public OrderProducts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
