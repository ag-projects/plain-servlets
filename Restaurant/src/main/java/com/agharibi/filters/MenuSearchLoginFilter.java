package com.agharibi.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = {"/searchResults.html", "/anotherUrl.html"})
public class MenuSearchLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String searchTerm = request.getParameter("searchTerm");
        System.out.println("user searched for: " + searchTerm);
        chain.doFilter(request, response);
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
