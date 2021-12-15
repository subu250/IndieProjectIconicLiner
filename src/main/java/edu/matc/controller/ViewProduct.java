package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@WebServlet(
        urlPatterns = {"/viewProducts"}
)

public class ViewProduct extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao productDao = new GenericDao(Product.class);
        GenericDao userDao = new GenericDao(User.class);
        int userId = 0;
        Set<Product> productList;
        String page = "/viewProducts.jsp";

        // get the userName
        String userName = req.getParameter("userName");
        try {
            List<User> allUsers = new ArrayList<>(userDao.getAll());
            for (User user : allUsers) {
                if (user.getUserName().equals(userName)) {
                    userId = user.getId();
                }
            }
            // get the User object
            User user = (User) userDao.getById(userId);
            productList = user.getProduct();
            req.setAttribute("products", productList);
            session.setAttribute("userName", userName);
        } catch (Exception e) {
            logger.error("Error retrieving user ", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}