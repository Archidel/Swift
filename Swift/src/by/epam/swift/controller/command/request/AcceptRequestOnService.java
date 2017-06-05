package by.epam.swift.controller.command.request;

import java.io.IOException;
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

/**Class for accept request on service.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class AcceptRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(AcceptRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idRequest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		boolean action = Boolean.parseBoolean(request.getParameter(ParameterName.STATUS_OF_OPERATION));
		HttpSession session = request.getSession();
		User User = (User) session.getAttribute(AttributeName.USER);
		int idAdmin = User.getId();
		int idUser = Integer.parseInt(request.getParameter(ParameterName.USER_ID));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
	
		try {
			requestService.acceptRequestOnService(idRequest, idAdmin, idUser, action);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_REQUEST_ON_SERVICE_LIST_ADMIN);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
