package webshopapp.webshopapp.domain;

import org.springframework.web.context.annotation.SessionScope;

public class CustomerLoginFormBean {

    String userName;

    public CustomerLoginFormBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
