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

public class MenuServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> fullMenu = menuDataService.getFullMenu();

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body><h1>Ricky's Restaurant:</h1>");
        out.println("<h2>Menu:</h2><ul>");

        for (MenuItem item : fullMenu) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='searchResults.html?searchTerm=vegetable'>View all of our chicken dishes</a>");
        out.println("</body></html>");
        out.close();
    }
}
