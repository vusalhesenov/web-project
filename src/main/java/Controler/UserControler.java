package Controler;

import Model.Category;
import Model.Product;
import Model.Unit;
import Service.ProductService;
import ServiceImpl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/saveProduct"})
public class UserControler extends HttpServlet {
     ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categroyId = req.getParameter("Category");
        String unitId = req.getParameter("Unit");
        String name = req.getParameter("Name");
        String price = req.getParameter("Price");


        Product product = new Product(name,Double.valueOf(price),new Category(Long.valueOf(categroyId)),new Unit(Long.valueOf(unitId)));
        product = productService.saveProduct(product);
        resp.sendRedirect("product?id=11"+product.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.findProductById(11L);
        req.setAttribute("productName",product.getName());
        req.setAttribute("price",product.getPrice());
        req.setAttribute("categoryName",product.getCategory().getName());
        req.setAttribute("unit",product.getUnit().getName());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("saveProduct.jsp");
        requestDispatcher.forward(req,resp);
    }
}