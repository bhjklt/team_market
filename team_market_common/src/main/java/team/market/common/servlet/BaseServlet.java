package team.market.common.servlet;

import team.market.common.annontation.RequiresPermission;
import team.market.common.auth.SecurityUtils;
import team.market.common.auth.Subject;
import team.market.common.auth.exception.UnauthorizedException;
import team.market.common.auth.pojo.Permission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -8055990479290051812L;

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type","text/html;charset=UTF-8");
		String methodName = req.getParameter("method");
		
		if(methodName == null || "".equals(methodName.trim())) {
			throw new RuntimeException("No Method Parameter");
		}
		
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			validatePermission(method);
		}catch (UnauthorizedException e) {
			e.printStackTrace();
			throw new UnauthorizedException();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	private void validatePermission(Method method) throws UnauthorizedException {
		RequiresPermission permission = method.getAnnotation(RequiresPermission.class);
		Subject subject = SecurityUtils.getSubject();
		if(permission != null && subject != null) {
			String value = permission.value();
			if (value.contains(",")) {
				String[] permissions = value.split(",");
				Set<Permission> pSet = new HashSet<Permission>();
				for (String p : permissions) {
					pSet.add(new Permission(p.trim()));
				}
				subject.checkPermissions(pSet);
			} else {
				subject.checkPermission(new Permission(value.trim()));
			}
		}

    }


}
