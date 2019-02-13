package com.agharibi.servlets;

import com.agharibi.data.MenuDao;
import com.agharibi.data.MenuDaoFactory;
import com.agharibi.domain.Order;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class OrderReceivedServlet extends HttpServlet {

	MenuDao menuDao = MenuDaoFactory.getMenuDao();
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int maxId = menuDao.getFullMenu().size();
		Order order = menuDao.newOrder(request.getUserPrincipal().getName());
		for (int i = 0; i <maxId; i++) {
			String quantity = request.getParameter("item_" + i);
			 try  
			  {  
			    int q = Integer.parseInt(quantity);
			    if (q > 0) menuDao.addToOrder(order.getId(), menuDao.getItem(i), q);
			  }  
			  catch(NumberFormatException e)
			  {
//				  System.out.println(e);
			    //that's fine it just means there wasn't an order for this item 
			  }  
			  
		}

		System.out.println("A new order has been received!");

		Double total = menuDao.getOrderTotal(order.getId());
		HttpSession session = request.getSession();
		session.setAttribute("total", total);

		response.sendRedirect("/thankYou.html");

	}
}
