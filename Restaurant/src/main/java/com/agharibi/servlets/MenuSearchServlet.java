package com.agharibi.servlets;

import com.agharibi.data.MenuDataService;
import com.agharibi.domain.MenuItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MenuSearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuDataService menuDataService = new MenuDataService();

        String searchTerm = req.getParameter("searchTerm");
        List<MenuItem> fullMenu = menuDataService.find(searchTerm);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");


        if (fullMenu.size() > 0) {


            out.println("<html><body><h1>Ricky's Restaurant:</h1>");
            out.println("<h2>Dishes containing: " + searchTerm + "</h2><ul>");

            for (MenuItem item : fullMenu) {
                out.println("<li>" + item + " " + item.getDescription() + "</li>");
            }
            out.println("</ul></body></html>");
        } else {
            out.println("<html><body><h1>Ricky's Restaurant:</h1>");
            out.println("<p>There are no dishes containing: </p>"+ searchTerm );
        }

        out.println("</body></html>");
        out.close();
    }
}
