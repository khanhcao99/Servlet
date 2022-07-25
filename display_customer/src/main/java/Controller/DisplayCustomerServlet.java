package Controller;

import Model.Customer;
import Model.CustomerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisplayCustomerServlet", value ="/DisplayCustomerServlet")
public class DisplayCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("display.jsp");
        CustomerManager customerManager = new CustomerManager();
        ArrayList<Customer> customers = customerManager.getCustomers();
        request.setAttribute("customers", customers);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
