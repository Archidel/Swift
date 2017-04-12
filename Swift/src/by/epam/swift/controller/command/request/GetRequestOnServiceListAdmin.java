package by.epam.swift.controller.command.request;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetRequestOnServiceListAdmin implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetRequestOnServiceListAdmin.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RequestService requestService = serviceFactory.getRequestService();
		
		try {
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = requestService.getAmountEntriesRequestList();
			requestService.getAmountEntriesRequestList();
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			
			List<RequestOnService> list = requestService.getRequestOnServiceList(numberPage);
			request.setAttribute(AttributeName.LIST, list);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
	
		
		
	}

}
