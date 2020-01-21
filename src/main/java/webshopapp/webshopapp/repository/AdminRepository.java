package webshopapp.webshopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshopapp.webshopapp.domain.Admin;


import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findByUserName(String userName);
}
