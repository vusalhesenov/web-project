package Controler;

import Model.Store;
import Service.StoreService;
import ServiceImpl.StoreServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/store"})

public class StoreController extends HttpServlet {
    StoreService storeService = new StoreServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Store> storeList = storeService.findAll();
        System.out.println(storeList);
        req.setAttribute("storeList",storeList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("store.jsp");
        requestDispatcher.forward(req,resp);
    }
}
