package by.epam.swift.controller.command.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.News;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**This class has implementation {@link Command}.
 * Class for upload news data to edit news form.
 * @author Albert Zarankovich
 */
public class UploadNewsDataToEdit implements Command {
	private static final Logger LOGGER = Logger.getLogger(UploadNewsDataToEdit.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idNews = Integer.parseInt(request.getParameter(ParameterName.NEWS_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		
		try {
			News news = newsService.getNewsById(idNews);
			request.setAttribute(AttributeName.MORE, news);
			request.getRequestDispatcher(PageName.EDIT_NEWS_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}
}
