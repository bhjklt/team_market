package team.market.administrator.filter;

import team.market.administrator.pojo.User;
import team.market.common.manager.ContextManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User admin = (User)session.getAttribute("admin");
        if(admin != null){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("/adminLogin.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
