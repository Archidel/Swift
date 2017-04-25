package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;

/**Class for exit for user's account.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class Logout implements Command {
	private static final Logger LOGGER = Logger.getLogger(Logout.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(AttributeName.LOGGED);
		session.removeAttribute(AttributeName.USER);
	
		try {
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	
	}
	
}
