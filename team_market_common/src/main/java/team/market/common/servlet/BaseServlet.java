package team.market.common.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -8055990479290051812L;

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodName = req.getParameter("method");
		
		if(methodName == null || "".equals(methodName.trim())) {
			throw new RuntimeException("No Method Parameter");
		}
		
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException(methodName + "(HttpServletRequest,HttpServletResponse) Not Found");
		}
		
		try {
			String result = (String)method.invoke(this, req, resp);
			if(result == null || "".equals(result.trim())) {
				return;
			}
			if(result.contains(":")) {
				int index = result.indexOf(":");
				String s = result.substring(0, index);
				String path = result.substring(index+1);
				if(s.equalsIgnoreCase("r")) {
					resp.sendRedirect(req.getContextPath() + path);
				} else if(s.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				} else {
					throw new RuntimeException("Operation " + s + " is wrong");
				}
			} else {
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println( methodName + " Internal Error");
			throw new RuntimeException(e);
		}
	}
}
