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

public class OrderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body><h1>Ricky's Restaurant</h1>");
        out.println("<h2>Order your food:</h2>");

        out.println("<form action='orderReceived.html' method='POST' >");
        out.println("<ul>");


        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();


        for(MenuItem menuItem : menuItems) {
            out.println("<li>" + menuItem + "<input type='text' name='item_" + menuItem.getId() + "' /></li>");
        }


        out.println("</ul>");
        out.println("<input type='submit' />");
        out.println("</form></body></html>");
        out.close();
    }
}
