package webshopapp.webshopapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import webshopapp.webshopapp.domain.Admin;
import webshopapp.webshopapp.domain.AdminLoginFormBean;
import webshopapp.webshopapp.domain.CustomerLoginFormBean;
import webshopapp.webshopapp.service.LoginAdminService;

@Controller
public class AdminController {

    @Autowired
    LoginAdminService loginAdminService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);


    @GetMapping("/loginAdmin")
    public String loginAdmin(Model model) {
        model.addAttribute("admin", new AdminLoginFormBean());
        model.addAttribute("message", "Please login:");
        return "loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String loginSubmit(@ModelAttribute AdminLoginFormBean adminLoginFormBean, Model model) {
        if (loginAdminService.login(adminLoginFormBean.getUserName())) {
            model.addAttribute("userName",adminLoginFormBean.getUserName());
            return "viewProducts";
        } else {
            model.addAttribute("message", "No such user, try again");
            return "loginAdmin";
        }
    }




}
