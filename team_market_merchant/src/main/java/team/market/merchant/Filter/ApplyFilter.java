package team.market.merchant.Filter;

import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;

import javax.servlet.*;
import java.io.IOException;

public class ApplyFilter implements Filter {

    private final static String INDEX_HTML = "index.jsp";
    private final static String NO_LOGIN = "请先登录";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isLogged()){
            chain.doFilter(request, response);
        }
        else {
            request.setAttribute("login_error",NO_LOGIN);
            request.getRequestDispatcher(INDEX_HTML).forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
