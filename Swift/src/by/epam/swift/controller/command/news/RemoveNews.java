package by.epam.swift.controller.command.news;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class RemoveNews implements Command {
	private static final Logger LOGGER = Logger.getLogger(RemoveNews.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int idNews = Integer.parseInt(request.getParameter(ParameterName.NEWS_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		
		try {
			newsService.removeNews(idNews);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}

		try {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_GET_NEWS_LIST_ADNIM_PAGE);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
	}

}
