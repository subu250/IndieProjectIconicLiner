package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.entity.Item;
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

/**
 * A servlet to view products
 *
 * @author subu
 */
@WebServlet(
        urlPatterns = {"/productDetails"}
)

public class ProductDetail extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Product.class);
        int id = (Integer.parseInt(req.getParameter("detailId")));

        String page = "/productDetails.jsp";
        try {
            Product productItem= (Product) genericDao.getById(id);
            List<Item> types = new ArrayList(productItem.getItemSet());
            logger.debug("The list of products: {}", productItem);
        } catch (Exception e) {
            logger.error("Error Info", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }

}