package org.example.tpo5_s25972;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/vehicle")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");

        if (type != null && !type.isEmpty()) {
            req.setAttribute("type", type);
            RequestDispatcher dispatcher = req.getRequestDispatcher("search");
            dispatcher.forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Brak parametru");
        }
    }

}
