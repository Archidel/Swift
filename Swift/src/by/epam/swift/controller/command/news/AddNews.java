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

/** <h1>AddNews</h1>
 * This class has implementation {@link Command}.
 * Class is used for add new news to the site.
 * @author Archangel
 */
public class AddNews implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddNews.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter(ParameterName.NEWS_TITLE);
		String description = request.getParameter(ParameterName.NEWS_DESCRIPTION);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		NewsService newsService = factory.getNewsService();
		boolean statusOperation = false;
		
		try {		
			newsService.addNews(title, description);
			statusOperation = true;
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		try {
			if(statusOperation){
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_NEWS_SUCCESS);				
			}else{
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_NEWS_ERROR);	
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
	}

}
