package by.epam.swift.controller.command.wrong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.PageName;

public class WrongRequest implements Command {
	private static final Logger LOGGER = Logger.getLogger(WrongRequest.class);
	
	@Override
	public void  executeCommand(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PageName.ERROR_WRONG_REQUEST).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
