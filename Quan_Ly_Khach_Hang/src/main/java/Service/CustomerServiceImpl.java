package Service;

import DAO.CustomerRepository;
import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public ArrayList<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return  customerRepository.findCustomerById(id);
    }

    @Override
    public void update( Customer customer) {
        customerRepository.updateCustomerById(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteCustomerById(id);
    }
}
