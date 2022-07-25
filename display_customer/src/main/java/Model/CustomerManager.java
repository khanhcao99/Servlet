package Model;

import java.util.ArrayList;

public class CustomerManager {
    private final ArrayList<Customer> customers = new ArrayList<>();

    public CustomerManager() {
        customers.add(new Customer("Cao Quốc Khánh", "02/09/1999", "Phú Mình", "https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/meme-hot-1.jpg"));
        customers.add(new Customer("Cao Quốc Khánh", "02/09/1999", "Phú Mình", "https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/meme-hot-1.jpg"));
        customers.add(new Customer("Cao Quốc Khánh", "02/09/1999", "Phú Mình", "https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/meme-hot-1.jpg"));
        customers.add(new Customer("Cao Quốc Khánh", "02/09/1999", "Phú Mình", "https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/meme-hot-1.jpg"));
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerManager{" +
                "customers=" + customers +
                '}';
    }
}
