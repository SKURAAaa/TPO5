package org.example.tpo5_s25972;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String category = (String) req.getAttribute("category");

        if (category != null && !category.isEmpty()) {
            // Pobranie listy samochodów z danej kategorii
            AutomobileData automobileData = new AutomobileData();
            List<Automobile> automobiles = automobileData.getAutomobilesByCategory(category);
            req.setAttribute("automobiles", automobiles);
// Przekazanie wyników do następnego servletu
            RequestDispatcher dispatcher = req.getRequestDispatcher("show");
            dispatcher.forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Brak atrybutu");
        }
    }
}
