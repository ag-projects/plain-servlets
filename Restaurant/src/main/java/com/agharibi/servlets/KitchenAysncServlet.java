package com.agharibi.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/kitchenAsyncServlet", asyncSupported = true)
public class KitchenAysncServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        AsyncContext asyncContext = request.startAsync(request, response);
        KitchenAsyncTask task = new KitchenAsyncTask();
        task.setAsyncContext(asyncContext);
        asyncContext.start(task);

    }
}
