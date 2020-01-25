package webshopapp.webshopapp.repositories;

import webshopapp.webshopapp.domain.Customer;
import webshopapp.webshopapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class MockCustomerRepository implements CustomerRepository {

    Customer customer = new Customer();

    public MockCustomerRepository() {
        customer.setId(3);
        customer.setUserName("anton");
    }

    @Override
    public List<Customer> findByUserName(String userName) {
        return null;
    }

    @Override
    public <S extends Customer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
