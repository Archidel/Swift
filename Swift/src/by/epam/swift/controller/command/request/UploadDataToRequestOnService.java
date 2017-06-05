package by.epam.swift.controller.command.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Tariff;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for upload data request on service form.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class UploadDataToRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(UploadDataToRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			List<String> typeList = tariffService.getListTypeOfTariff();
			List<Tariff> list = tariffService.getListTariffActiveStatus();
			request.setAttribute(AttributeName.LIST, list);
			request.setAttribute(AttributeName.TARIFF_TYPE_LIST, typeList);
			request.getRequestDispatcher(PageName.REQUEST_ON_SERVICE_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
