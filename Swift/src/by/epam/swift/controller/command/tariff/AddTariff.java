package by.epam.swift.controller.command.tariff;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for add new tariff.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class AddTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String title = request.getParameter(ParameterName.TARIFF_TITLE);
		String price = request.getParameter(ParameterName.TARIFF_PRICE);
		String type = request.getParameter(ParameterName.TARIFF_TYPE);
		String description = request.getParameter(ParameterName.TARIFF_DESCRIPTION);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			tariffService.addTariff(title, description, type, price);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_SUCCESS);	
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_ERROR);	
			LOGGER.error(e);
		}
	}

}
