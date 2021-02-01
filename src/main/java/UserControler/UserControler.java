package UserControler;

import Dao.UserLoginDao;
import DaoImpl.UserLoginDaoImpl;
import Model.Category;
import Model.Product;
import Model.Unit;
import Model.UserLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(urlPatterns = {"/product"})
public class UserControler extends HttpServlet {
    UserLoginDao userLoginDao = new UserLoginDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categroyId = req.getParameter("Category");
        String unitId = req.getParameter("Unit");
        String name = req.getParameter("Name");
        String price = req.getParameter("Price");


        Product product = new Product(name,Double.valueOf(price),new Category(Long.valueOf(categroyId)),new Unit(Long.valueOf(unitId)));
        product = userLoginDao.save(product);

        resp.sendRedirect("product?id="+product.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = userLoginDao.findProductById(Long.valueOf(id));
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        req.setAttribute("productName",product.getName());
        req.setAttribute("price",product.getPrice());
        req.setAttribute("categoryName",product.getCategory().getName());
        req.setAttribute("unit",product.getUnit().getName());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product.jsp");
        requestDispatcher.forward(req,resp);
    }
}