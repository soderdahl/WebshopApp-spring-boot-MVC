package webshopapp.webshopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class WebShopAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebShopAppApplication.class, args);
    }

}
