package webshopapp.webshopapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import webshopapp.webshopapp.dao.AdminRepository;
import webshopapp.webshopapp.model.Admin;
import java.util.List;


@Service
@SessionScope
public class LoginAdminService {

    @Autowired
    AdminRepository adminRepository;

    Admin admin;
    boolean isLoggedIn;

    Logger logger = LoggerFactory.getLogger(LoginCustomerService.class);

    public LoginAdminService() {
    }

    public boolean login(String userName) {
        List<Admin> adminList = adminRepository.findByUserName(userName);
        if (adminList.size()>0) {
           admin = adminList.get(0);
            isLoggedIn = true;
            return true;
        } else {
            return false;
        }
    }
}
