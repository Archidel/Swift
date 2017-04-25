package by.epam.swift.controller.command.news;

import java.io.IOException;

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

/**This class has implementation {@link Command}.
 * Class is used for add new news to the site.
 * @author Albert Zarankovich
 */

public class EditNews implements Command {
	private static final Logger LOGGER = Logger.getLogger(EditNews.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter(ParameterName.NEWS_TITLE);
		String description = request.getParameter(ParameterName.NEWS_DESCRIPTION);
		int idNews = Integer.parseInt(request.getParameter(ParameterName.NEWS_ID));
		
		News news = new News();
		news.setId(idNews);
		news.setTitle(title);
		news.setDescription(description);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		
		try {
			newsService.editNews(news);
			news = newsService.getNewsById(idNews);
			request.setAttribute(AttributeName.MORE, news);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_NEWS_PAGE + news.getId());
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_NEWS_PAGE + news.getId());
			LOGGER.error(e);
		}
	}

}
