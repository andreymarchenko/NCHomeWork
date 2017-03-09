package main.Servlets;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet
public class SendMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String text = req.getParameter("text");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.yandex.com");
        properties.put("mail.smtp.port", "587");

        String login = "egor.rozhdestwensky@yandex.ru";
        String pass = "1122334455";

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, pass);
            }
        };

        Session session = Session.getDefaultInstance(properties, authenticator);

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(login));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            resp.getWriter().write("Your message was sent");

        } catch (MessagingException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
        }
    }
}
