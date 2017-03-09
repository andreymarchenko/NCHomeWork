package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HomeWork10")
public class FirstServlet extends HttpServlet {

    public final static String LOGIN = "login";
    public final static String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(login.equals(LOGIN) && password.equals(PASSWORD)) {
            resp.getWriter().write("<h1>Login and Password are correct</h1>");
        } else {
            resp.getWriter().write("<h1>Login and Password are incorrect</h1>");
        }




    }
}
