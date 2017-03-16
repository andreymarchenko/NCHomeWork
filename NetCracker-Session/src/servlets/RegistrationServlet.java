package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@WebServlet
public class RegistrationServlet extends HttpServlet {

    private String path = "C:\\Users\\Andrey\\Desktop\\NetCracker-Session\\src\\users.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Scanner in = new Scanner(new File(path));
        StringBuffer data = new StringBuffer();

        while (in.hasNextLine()) {
            data.append(in.nextLine()).append(System.getProperty("line.separator"));
        }

        if (!login.equals("") && !password.equals("")) {
            FileWriter writer = new FileWriter("C:\\Users\\Andrey\\Desktop\\NetCracker-Session\\src\\users.txt", false);
            writer.write(data.toString() + login + "/" + password);
            writer.flush();
            writer.close();
            resp.sendRedirect("/loginSession.html");
        }
        else resp.getWriter().write("<h1>Login and Password are correct</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
