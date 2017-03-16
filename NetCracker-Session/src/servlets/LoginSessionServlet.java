package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Scanner;

@WebServlet
public class LoginSessionServlet extends HttpServlet {

    private String path = "C:\\Users\\Andrey\\Desktop\\NetCracker-Session\\src\\users.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Scanner in = new Scanner(new File(path));

        while (in.hasNextLine()) {
            StringBuffer data = new StringBuffer();
            data.append(in.nextLine());
            String[] str = data.toString().split("/");
            if (login.equals(str[0]) && password.equals(str[1].split(System.getProperty("line.separator"))[0])) {
                resp.getWriter().write("<h1>Welcome</h1>" + login);
                session.setAttribute("login", login);
                session.setAttribute("password", password);
                return;
            } else if (!session.isNew()
                    && req.getParameter("login").equals("")
                    && req.getParameter("password").equals("")) {
                resp.getWriter().write("<h1>Welcome</h1>" + session.getAttribute("login"));
                return;
            }
        }
        resp.sendRedirect("/registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
