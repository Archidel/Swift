package by.epam.swift.controller.command.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.News;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.controller.configuration.RequestMessage;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetNewsListAdmin implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetNewsListAdmin.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory  = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		
		try {
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = newsService.getAmountEntriesNewsListAdmin();
			request.setAttribute(AttributeName.AMOUNT_RESULT, numberEntries);
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			
			List<News> list = newsService.getNewsListAdmin(numberPage);
			request.setAttribute(AttributeName.LIST, list);
		} catch (ServiceException e){
			request.setAttribute(AttributeName.RESULT, RequestMessage.ERROR_RESULT);
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.GET_NEWS_LIST_ADMIN_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
