package by.epam.swift.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.command.CommandProvider;
import by.epam.swift.controller.configuration.CommandName;

/** Main servlet.
 * @author Archangel
 *
 */
public final class Controller extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(Controller.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandProvider provider = CommandProvider.getInstance();
		String commandName = request.getParameter(CommandName.COMMAND.name().toLowerCase());
		Command command = provider.getCommand(commandName);
		try{
			command.executeCommand(request, response);			
		}catch (IOException e) {
			LOGGER.error(e);
		}
	}

}
