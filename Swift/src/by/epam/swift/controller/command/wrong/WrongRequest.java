package by.epam.swift.controller.command.wrong;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.swift.controller.PageName;
import by.epam.swift.controller.command.Command;

/** Command for worn request. When command not found we get this class. 
 * This class has implementation {@link Command}.
 * @author Archangel
 */
public class WrongRequest implements Command {
	
	@Override
	public void  executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect(request.getContextPath() + PageName.ERROR_REQUEST_PAGE);
	}
	
}
