package edu.matc.controller;

import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/** Authentication process using AWS Cognito
 *
 */
@WebServlet(
        urlPatterns = {"/logIn"}
)

/** Authentication process using AWS Cognito
 *
 */
public class LogIn extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //cognito info
        ServletContext server = getServletContext();
        String redirect_url = (String)server.getAttribute("REDIRECT_URL");
        String client_id = (String)server.getAttribute("CLIENT_ID");
        String login_url = (String)server.getAttribute("LOGIN_URL");

        if (redirect_url==null || client_id==null || login_url==null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        } else {
            String url = login_url + "?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_url;
            resp.sendRedirect(url);
        }

    }
}