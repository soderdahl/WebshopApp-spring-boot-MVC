package webshopapp.webshopapp.domain;

import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;


@Entity
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String userName;

    public Customer() {
    }

    public Customer(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
