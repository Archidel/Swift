package by.epam.swift.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.swift.bean.User;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;

/**Tracks if user has rights to access certain pages.
 * @author Archangel
 */
public class SecurityFilterJSP implements Filter{
	public static final String ADMIN = "admin";
	public static final String MODERATOR = "moderator";
	public static final String USER = "user";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession(true);
		Object obj = session.getAttribute(AttributeName.USER);

		if(obj == null){
			servletResponse.sendRedirect(servletRequest.getContextPath() + PageName.SECURITY_PAGE);
		}else{
			User user = (User) obj;
			if(user.getPosition().equals(USER) || user.getPosition() == null){
				servletResponse.sendRedirect(servletRequest.getContextPath() + PageName.SECURITY_PAGE);
			}else{
				chain.doFilter(servletRequest, servletResponse);
			}
		}
	}

}
