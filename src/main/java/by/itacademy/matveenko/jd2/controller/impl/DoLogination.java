package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import by.itacademy.matveenko.jd2.service.UserService;
import by.itacademy.matveenko.jd2.service.impl.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoLogination implements Command {

	private final UserService service = ServiceProvider.getInstance().getUserService();
	private FilterChain filterChain;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");;
		String password = request.getParameter("password");
		
		if (!login.equals(null) && !password.equals(null)) {
								
		try {
			NewUserInfo userDetails = service.logination(login, password);
			if (userDetails != null) {
				//UserRole role = userDetails.getRole();
				AuthorizationFilter authFilter = new AuthorizationFilter();
				authFilter.doFilter(request, response, filterChain);				
			} else {
				// go to index-logination with message
			}
		} catch (ServiceException e) {
			// logging e
			// go-to error page
		}
		// response.getWriter().print("do logination");
	}

}
}
