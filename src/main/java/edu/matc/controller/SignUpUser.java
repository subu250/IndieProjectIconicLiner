package edu.matc.controller;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )

    public class SignUpUser extends HttpServlet {

        private final Logger logger = LogManager.getLogger(this.getClass());

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            User user = new User();
            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("email"));
            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            user.setPassword(req.getParameter("password"));


            logger.debug("Adding User: " + user);


        }
    }
