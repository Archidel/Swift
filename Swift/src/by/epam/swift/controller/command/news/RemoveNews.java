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

/**Class for remove news.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class RemoveNews implements Command {
	private static final Logger LOGGER = Logger.getLogger(RemoveNews.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idNews = Integer.parseInt(request.getParameter(ParameterName.NEWS_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		
		try {
			newsService.removeNews(idNews);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_GET_NEWS_LIST_ADMIN_PAGE);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}		
	}

}
