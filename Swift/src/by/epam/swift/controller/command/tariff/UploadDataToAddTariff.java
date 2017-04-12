package by.epam.swift.controller.command.tariff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class UploadDataToAddTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(UploadDataToAddTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();

		try {
			List<String> list = tariffService.getListTypeOfTariff();
			request.setAttribute(AttributeName.LIST, list);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.ADD_TARIFF_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
