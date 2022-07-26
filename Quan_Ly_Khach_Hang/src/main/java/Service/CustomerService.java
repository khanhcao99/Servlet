package Service;

import Model.Customer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface CustomerService{
    List<Customer> findAll();

    void add (Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void delete(int id);

}
