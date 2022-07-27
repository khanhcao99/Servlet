package Controller;

import Model.Customer;
import Service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
//                Điều hướng việc hiển thị form tạo khách hàng mới:
                showCreateForm(request, response);
                break;
            case "edit":
//                Điều hướng hiển thị form cập nhật thông tin khách hàng:
                showEditForm(request, response);
                break;
            case "delete":
//                Điều hướng việc hiển thị form xóa khách hàng:
                showDeleteForm(request, response);
                break;
            case "view":
//                Phát triển tính năng xem chi tiết một khách hàng
                viewCustomer(request, response);
                break;
            default:
//                Điều hướng action hiển thị danh sách khách hàng về phương thức listCustomers(request, response);
                listCustomers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

//    Phương thức listCustomers(request, response) nhận về danh sách khách hàng và chuyển sang view customer/list.jsp để hiển thị.
    private void listCustomers(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Customer> customers = customerService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customers", customers);
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);

    }
    private void  createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random()*1000);
        Customer customer = new Customer(id, name, email, address);
        customerService.add(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        }else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        dispatcher.forward(request, response);
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findById(id);
        RequestDispatcher  dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        }else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customerService.update(customer);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        }else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        }else {
            customerService.delete(id);
            request.setAttribute("message", "Delete succesfully!");
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        }else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        dispatcher.forward(request, response);
    }

}
