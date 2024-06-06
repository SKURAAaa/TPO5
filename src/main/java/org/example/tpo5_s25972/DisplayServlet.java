package org.example.tpo5_s25972;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Car> autkaDoPrintowania = (List<Car>) req.getAttribute("cars");

        if (autkaDoPrintowania == null || autkaDoPrintowania.isEmpty())
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Nie znaleziono aut");
            return;
        }
        resp.setContentType("text/html");
        PrintWriter printWricik = resp.getWriter();

        printWricik.println("<html><body><h1>S25972</h1>");
        printWricik.println("<table border='1'><tr><th>Type</th><th>Brand</th><th>Production Year</th><th>Fuel Consumption</th></tr>");
        for (Car autka : autkaDoPrintowania) {
            printWricik.println("<tr><td>" + autka.getType() + "</td><td>" + autka.getBrand() + "</td><td>" + autka.getProdYear() + "</td><td>" + autka.getConsumpt() + "</td></tr>");
        }

        printWricik.println("</table></body></html>");
        printWricik.close();
    }

}

