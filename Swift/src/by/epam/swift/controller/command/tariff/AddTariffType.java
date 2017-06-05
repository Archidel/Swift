package by.epam.swift.controller.command.tariff;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for add new type of tariff.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class AddTariffType implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddTariffType.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String tariffType = request.getParameter(ParameterName.TARIFF_TYPE);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			tariffService.addTariffType(tariffType);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_TYPE_SUCCESS);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_TYPE_ERROR);	
			LOGGER.error(e);
		}
	}

}
