package com.agharibi.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/searchResults.html")
public class MenuSearchCorrectionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String searchTerm = request.getParameter("searchTerm");
        if (searchTerm.toLowerCase().equals("chock")) {
            MenuSearchCorrectionRequestWrapper wrapper = new MenuSearchCorrectionRequestWrapper((HttpServletRequest) request);
            wrapper.setNewSearchTerm("chicken");
            chain.doFilter(wrapper, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void destroy() {

    }
}
