package by.epam.swift.controller.command.localization;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;

/** <h1>Localization</h1>
 * This class has implementation {@link Command}.
 * Class is used for change the local.
 * @author Archangel
 */
public class Localization implements Command {
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession(true).setAttribute(AttributeName.LOCAL, request.getParameter(ParameterName.LOCAL));
		response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
	}
	 
}
