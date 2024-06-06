package org.example.tpo5_s25972;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
// Pobranie listy samochodów z atrybutu żądania
        List<Automobile> automobiles = (List<Automobile>) req.getAttribute("automobiles");

        if (automobiles == null || automobiles.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Nie znaleziono aut");
            return;
        }
        PrintWriter writer = resp.getWriter();

        writer.println("<html><body><h1>S25972</h1>");
        writer.println("<table border='1'><tr><th>Typ</th><th>Marka</th><th>Rok</th><th>Ile pali</th></tr>");
        for (Automobile automobile : automobiles) {
            writer.println("<tr><td>" + automobile.getCategory() + "</td><td>" + automobile.getBrand() + "</td><td>" + automobile.getProductionYear() + "</td><td>" + automobile.getFuelConsumption() + "</td></tr>");
        }
        writer.println("</table>");


        writer.println("<button onclick=\"window.history.back()\">Back</button>");

        writer.println("</body></html>");
        writer.close();
    }
}
