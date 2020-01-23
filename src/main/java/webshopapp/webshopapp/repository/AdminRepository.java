package webshopapp.webshopapp.repository;

import org.springframework.data.repository.CrudRepository;
import webshopapp.webshopapp.domain.Admin;


import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    List<Admin> findByUserName(String userName);
}
