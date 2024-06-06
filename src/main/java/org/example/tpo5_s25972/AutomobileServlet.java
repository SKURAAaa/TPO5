package org.example.tpo5_s25972;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//żądania wyszukiwania samochodów na podstawie kategorii

public class AutomobileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
// Pobranie parametru kategorii z formularza
        String category = req.getParameter("category");

        if (category != null && !category.isEmpty()) {
            // Przekazanie kategorii do następnego servletu
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getRequestDispatcher("find");
            dispatcher.forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Brak parametru");
        }
    }
}
