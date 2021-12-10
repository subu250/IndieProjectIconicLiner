package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.matc.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ViewProduct", urlPatterns = { "/viewProduct" } )


    public class ViewProduct extends HttpServlet {
        private final Logger logger = LogManager.getLogger(this.getClass());

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            GenericDao<Product> dao = DaoFactory.createDao(Product.class);
            List<Product> products = dao.getAll();
            req.setAttribute("products", products);
            logger.debug("View list..." + products);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/viewProduct" +
                    ".jsp");
            dispatcher.forward(req, resp);
        }
    }

