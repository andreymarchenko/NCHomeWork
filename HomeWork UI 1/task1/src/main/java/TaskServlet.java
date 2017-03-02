import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double a, b, c;
        a = Double.parseDouble(req.getParameter("A"));
        b = Double.parseDouble(req.getParameter("B"));
        c = Double.parseDouble(req.getParameter("C"));

        List<Double> roots = new ArrayList<>();
        double d;
        double x1, x2;

        d = Math.pow(b, 2) - (4 * a * c);

        if (d > 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / (2 * a);
            x2 = ((-1) * b - Math.sqrt(d)) / (2 * a);
            roots.add(x1);
            roots.add(x2);
        } else if (d == 0) {
            x1 = (-1 * b) / (2 * a);
            roots.add(x1);
        } else {
            // d < 0
        }

        Gson gson = new Gson();
        String jsonResp = gson.toJson(roots);

        resp.getWriter().write(jsonResp);

    }
}
