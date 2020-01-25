package webshopapp.webshopapp.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToOne
    private Customer customer;


    public Orders() {
    }

    public Orders(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    Set<OrderProducts> orderProductsList;

    public Set<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(Set<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
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
