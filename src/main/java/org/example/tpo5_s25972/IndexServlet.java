package org.example.tpo5_s25972;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//obsługi strony głównej i pobierania kategorii samochodów.
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AutomobileData automobileData = new AutomobileData();
        List<String> categories = automobileData.getCategories();
        req.setAttribute("categories", categories);
        //przekazanie danych cateory do jsp strony
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
