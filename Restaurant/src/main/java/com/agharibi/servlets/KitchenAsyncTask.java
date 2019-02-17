package com.agharibi.servlets;

import com.agharibi.data.MenuDao;
import com.agharibi.data.MenuDaoFactory;
import com.agharibi.domain.Order;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class KitchenAsyncTask implements Runnable {

    private AsyncContext asyncContext;

    public void setAsyncContext(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {

        HttpServletRequest request = (HttpServletRequest) this.asyncContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) this.asyncContext.getResponse();

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        long size = Long.parseLong(request.getParameter("size"));

        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        while (menuDao.getAllOrders().size() < size) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                asyncContext.complete();
                throw new RuntimeException(e);
            }
        }

        Order order = menuDao.getOrder(size);
        out.println("<p><strong>Next order:</strong></br>" + order.toString() + "</p>");
        out.close();
        asyncContext.complete();

    }
}
