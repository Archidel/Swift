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

public class EditTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(EditTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int idTariff = Integer.parseInt(request.getParameter(ParameterName.TARIFF_ID));
		String title = request.getParameter(ParameterName.TARIFF_TITLE);
		String description = request.getParameter(ParameterName.TARIFF_DESCRIPTION);
		String price = request.getParameter(ParameterName.TARIFF_PRICE);

		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			tariffService.editTariff(idTariff, title, description, price);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_TARIFF + idTariff);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
