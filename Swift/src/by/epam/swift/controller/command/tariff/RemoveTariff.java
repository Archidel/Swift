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

public class RemoveTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(RemoveTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String tariffType = request.getParameter(ParameterName.TARIFF_TYPE);
		int idTariff = Integer.parseInt(request.getParameter(ParameterName.TARIFF_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			tariffService.removeTariff(idTariff);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_REMOVE_TARIFF + tariffType + "&page=1");
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
