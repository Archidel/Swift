package by.epam.swift.controller.command.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.News;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetSingleNews implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetSingleNews.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idNews = Integer.parseInt(request.getParameter(ParameterName.NEWS_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		
		try {
			News news = newsService.getNewsById(idNews);
			request.setAttribute(AttributeName.MORE, news);
			request.getRequestDispatcher(PageName.GET_SINGLE_NEWS_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
