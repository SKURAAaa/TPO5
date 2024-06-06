package org.example.tpo5_s25972;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = (String) req.getAttribute("type");

        if (type != null && !type.isEmpty()) {
            CarObject carObject = new CarObject();
            List<Car> autka = carObject.getCarsByType(type);
            req.setAttribute("cars", autka);

            RequestDispatcher dispatcher = req.getRequestDispatcher("display");
            dispatcher.forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Brak atrybutu");
        }
    }

}
