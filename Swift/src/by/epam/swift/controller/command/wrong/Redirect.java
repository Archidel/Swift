package by.epam.swift.controller.command.wrong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;

/**Class for redirects on difference pages.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class Redirect implements Command {
	private static final Logger LOGGER = Logger.getLogger(Redirect.class); 
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pageName = request.getParameter(ParameterName.PAGE_NAME);
		boolean statusOperation = Boolean.parseBoolean(request.getParameter(ParameterName.STATUS_OF_OPERATION));
		String message = request.getParameter(ParameterName.MESSAGE);
		
		if(statusOperation){
			request.setAttribute(AttributeName.STATUS_SUCCESS, message);
		}else{
			request.setAttribute(AttributeName.STATUS_ERROR, message);
		}
		
		try {
			request.getRequestDispatcher(pageName).forward(request, response);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
			LOGGER.error(e);
		}
	}

}
