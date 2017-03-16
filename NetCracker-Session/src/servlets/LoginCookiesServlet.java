package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Scanner;

@WebServlet
public class LoginCookiesServlet extends HttpServlet {

    private String path = "C:\\Users\\Andrey\\Desktop\\NetCracker-Session\\src\\users.txt";
    private int indicator = 0;
    private Cookie[] cookies = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        cookies = req.getCookies();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Scanner in = new Scanner(new File(path));

        while (in.hasNextLine()) {
            StringBuffer data = new StringBuffer();
            data.append(in.nextLine());
            String[] str = data.toString().split("/");
            if (login.equals(str[0]) && password.equals(str[1].split(System.getProperty("line.separator"))[0])) {
                Cookie loginCookie = new Cookie("loginCookie", req.getParameter("login"));
                Cookie passwordCookie = new Cookie("passwordCookie", req.getParameter("password"));
                resp.addCookie(loginCookie);
                resp.addCookie(passwordCookie);
                indicator++;
                resp.getWriter().write("<h1>Welcome</h1>" + login);
                return;
            } else if (indicator != 0) {
                resp.getWriter().write("<h1>Welcome</h1>" + find("loginCookie", cookies).getValue());
                return;
            }
        }
        resp.sendRedirect("/registration.html");
    }

    public static Cookie find(String str, Cookie[] cookies) {
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals(str)) {
                cookie = c;
            }

        }
        return cookie;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
