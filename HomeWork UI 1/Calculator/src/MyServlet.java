import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 02.03.2017.
 */

@WebServlet("/Calculator")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double a, b, c;
        a = Double.parseDouble(req.getParameter("a"));
        b = Double.parseDouble(req.getParameter("b"));
        c = Double.parseDouble(req.getParameter("c"));

        String result = "";

        double d;
        double x1, x2;

        d = Math.pow(b, 2) - (4 * a * c);

        if (d > 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / (2 * a);
            x2 = ((-1) * b - Math.sqrt(d)) / (2 * a);
            result += x1 + "/" + x2;
        } else if (d == 0) {
            x1 = (-1 * b) / (2 * a);
            result += x1;
        } else {
        }

        resp.getWriter().write(result);
    }
}
