package by.epam.swift.controller.command.tariff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Tariff;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.controller.configuration.RequestMessage;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetSingleTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetSingleTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String idTariff = request.getParameter(ParameterName.TARIFF_ID);
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			Tariff tariff = tariffService.getTariffById(idTariff);
			request.setAttribute(AttributeName.MORE, tariff);
		} catch (ServiceException e) {
			request.setAttribute(AttributeName.STATUS_ERROR, RequestMessage.ERROR_RESULT);
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.GET_SINGLE_TARIFF).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
	
	}

}
