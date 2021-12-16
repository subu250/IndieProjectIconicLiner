package edu.matc.controller;

import edu.matc.entity.Item;
import edu.matc.entity.Product;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = { "/itemList" })

public class ItemList extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Item.class);
        int id = (Integer.parseInt(req.getParameter("itemId")));
        String page = "/item.jsp";
        try {
            Product products = (Product) genericDao.getById(id);
            // List<Item> items = new ArrayList(products.getItem());

            //req.setAttribute("itemSet", items);
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Error ", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String list = req.getParameter("item");
        req.setAttribute("text", list);
        req.getRequestDispatcher("/item.jsp").forward(req, resp);
    }

}
