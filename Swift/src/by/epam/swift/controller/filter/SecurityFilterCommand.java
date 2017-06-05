package by.epam.swift.controller.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;

/**Tracks if user has rights to access certain pages.
 * @author Archangel
 */
public class SecurityFilterCommand implements Filter{
	private List<String> list = null;
	public static final String ADMIN = "admin";
	public static final String MODERATOR = "moderator";
	public static final String USER = "user";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		list = new ArrayList<String>();
		list.add("add_news");
		list.add("upload_news_data_to_edit");
		list.add("edit_news");
		list.add("remove_news");
		list.add("get_news_list_admin");
		list.add("add_tariff");
		list.add("get_tariff_list_admin");
		list.add("upload_data_to_edit_tariff");
		list.add("upload_data_to_add_tariff");
		list.add("edit_tariff");
		list.add("remove_tariff");
		list.add("add_tariff_type");
		list.add("remove_agreement");
		list.add("get_agreement_list");
		list.add("get_single_agreement");
		list.add("accept_agreement");
		list.add("set_user_block");
		list.add("get_user_list");
		list.add("change_position");
		list.add("upload_data_to_change_position");
		list.add("upload_data_to_set_block");
		list.add("remove_request_on_servoce");
		list.add("accept_request_on_service");
		list.add("get_request_on_service_list_admin");
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;	
		String command = request.getParameter(ParameterName.COMMAND);
		
		if(command != null){
			boolean isExistCommand = false;
		
			for(String line : list){
				if(command.equalsIgnoreCase(line)){
					isExistCommand = true;
					break;
				}
			}
		
			if(isExistCommand){
				HttpSession session = request.getSession();
				Object object = session.getAttribute(AttributeName.USER);
				if(object == null){
					response.sendRedirect(request.getContextPath() + PageName.SECURITY_PAGE);
				}else{
					User user = (User) object;
					if(user.getPosition().equals(USER) || user.getPosition() == null){
						response.sendRedirect(request.getContextPath() + PageName.SECURITY_PAGE);
					}else{
						chain.doFilter(request, response);						
					}
				}
			}else{
				chain.doFilter(servletRequest, servletResponse);
			}
		}else{
			chain.doFilter(servletRequest, servletResponse);
		}
	}

}
