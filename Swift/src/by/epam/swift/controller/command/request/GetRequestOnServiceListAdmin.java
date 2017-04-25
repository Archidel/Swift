package by.epam.swift.controller.command.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for get request on service list for user.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetRequestOnServiceListAdmin implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetRequestOnServiceListAdmin.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RequestService requestService = serviceFactory.getRequestService();
		
		try {
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = requestService.getAmountEntriesRequestList();
			requestService.getAmountEntriesRequestList();
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			
			List<RequestOnService> list = requestService.getRequestOnServiceList(numberPage);
			request.setAttribute(AttributeName.LIST, list);
			request.getRequestDispatcher(PageName.REQUEST_ON_SERVICE_LIST_ADMIN_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);		
		}
	}

}
