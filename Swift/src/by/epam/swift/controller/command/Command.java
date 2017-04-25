package by.epam.swift.controller.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**<h1>Interface pattern command</h1>
 * This pattern performs a distribution function. Forming requests and response.
 * @author Albert Zarankovich
 */

public interface Command {
	/**<h1>Execute command</h1>
	 * This method is used <b>HttpServletRequest</b> and <b>HttpServletResponse</b> and execute this command.
	 * @param request
	 * @param response
	 */
	void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
