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

public class AddTariffType implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddTariffType.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String tariffType = request.getParameter(ParameterName.TARIFF_TYPE);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		boolean statusOperation = false;
		
		try {
			tariffService.addTariffType(tariffType);
			statusOperation = true;
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
	
		try {
			if(statusOperation){
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_TYPE_SUCCESS);
			}else{
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_TARIFF_TYPE_ERROR);	
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}		

	}

}
