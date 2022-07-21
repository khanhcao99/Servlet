import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", value = "/ProductDiscountCalculatorServlet")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double listPrice = Double.parseDouble(request.getParameter("ListPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("DiscountPercent"));

        double discountAmount = (listPrice/100)*discountPercent;
        double discountPrice = listPrice - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Discount Amount: " + discountAmount + "<br>");
        writer.println("Discount Price: " + discountPrice + "");
        writer.println("</html>");

    }
}
