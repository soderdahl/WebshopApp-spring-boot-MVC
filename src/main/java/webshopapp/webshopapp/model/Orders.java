package webshopapp.webshopapp.model;


import javax.persistence.*;

@Entity
@Table(name = "`orders`")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    private Customer customer;

    public Orders() {
    }

    public Orders(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
