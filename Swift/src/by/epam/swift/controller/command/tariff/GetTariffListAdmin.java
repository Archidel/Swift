package by.epam.swift.controller.command.tariff;

import java.io.IOException;
import java.util.List;

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

public class GetTariffListAdmin implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetTariffListAdmin.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		String tariffType = request.getParameter(ParameterName.TARIFF_TYPE);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			request.setAttribute(AttributeName.TARIFF_TYPE, tariffType);
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = tariffService.getAmountEntriesListTariffInactiveStatus(tariffType);
			request.setAttribute(AttributeName.AMOUNT_RESULT, numberEntries);
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			List<Tariff> list = tariffService.getListTariffInactiveStatus(numberPage, tariffType);
			request.setAttribute(AttributeName.LIST, list);
		} catch (ServiceException e) {
			request.setAttribute(AttributeName.STATUS_ERROR, RequestMessage.ERROR_RESULT);
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.TARIFF_LIST_ADMIN_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
