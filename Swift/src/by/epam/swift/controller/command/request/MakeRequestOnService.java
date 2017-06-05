package by.epam.swift.controller.command.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for make request on service.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class MakeRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(MakeRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		
		int idUser = user.getId();
		Date blockDate = user.getBlockedTill();
		String title = request.getParameter(ParameterName.TARIFF_TITLE);
		String type = request.getParameter(ParameterName.TARIFF_TYPE);
		String serviceAction = request.getParameter(ParameterName.REQUEST_SERVICE_ACTION);
		
		ServiceFactory factory  = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
		
		try {
			requestService.makeRequestOnService(title, type, serviceAction, idUser, blockDate);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_MAKE_REQUEST_ON_SERVICE_SUCCESS);			
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_MAKE_REQUEST_ON_SERVICE_ERROR);	
			LOGGER.error(e);
		}		
	}

}
