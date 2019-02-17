package com.agharibi.servlets;

import com.agharibi.data.MenuDao;
import com.agharibi.data.MenuDaoFactory;
import com.agharibi.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MenuServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<MenuItem> menuItems = menuDao.getFullMenu();

        req.setAttribute("menuItems", menuItems);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/menu.jsp");
        dispatch.forward(req, resp);

    }
}
