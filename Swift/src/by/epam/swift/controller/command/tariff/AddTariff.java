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

public class AddTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter(ParameterName.TARIFF_TITLE);
		String price = request.getParameter(ParameterName.TARIFF_PRICE);
		String type = request.getParameter(ParameterName.TARIFF_TYPE);
		String description = request.getParameter(ParameterName.TARIFF_DESCRIPTION);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		boolean statusOperation = false;
		
		try {
			tariffService.addTariff(title, description, type, price);
			statusOperation = true;
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		try {
			if(statusOperation){
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_SUCCESS);		
			}else{
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_ERROR);	
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

}
