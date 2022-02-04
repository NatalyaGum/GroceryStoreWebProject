package by.example.webstore.controller.command.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import by.example.webstore.controller.command.ParameterAndAttribute;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CurrentPageFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String currentPage = httpRequest.getRequestURL().toString();

        if (currentPage.contains("jsp/")) {
            int index = currentPage.indexOf("jsp/") ;
            currentPage = currentPage.substring(index);
            httpRequest.getSession().setAttribute(ParameterAndAttribute.CURRENT_PAGE, currentPage);
        }
        else if (currentPage.contains("controller") && !httpRequest.getParameterMap().isEmpty()
                && httpRequest.getQueryString() != null &&
                !httpRequest.getQueryString().contains("command=change_locale")) {
            int index = currentPage.indexOf("controller");
            currentPage = currentPage.substring(index) + "?" + httpRequest.getQueryString();
            httpRequest.getSession().setAttribute(ParameterAndAttribute.CURRENT_PAGE, currentPage);
        }
        filterChain.doFilter(httpRequest, servletResponse);
    }
}