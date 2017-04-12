package by.epam.swift.controller.command.wrong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.ParameterName;

public class Redirect implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String pageName = request.getParameter(ParameterName.PAGE_NAME);
		boolean statusOperation = Boolean.parseBoolean(request.getParameter(ParameterName.STATUS_OF_OPERATION));
		String message = request.getParameter(ParameterName.MESSAGE);
		
		if(statusOperation){
			request.setAttribute(AttributeName.STATUS_SUCCESS, message);
		}else{
			request.setAttribute(AttributeName.STATUS_ERROR, message);
		}
		
		try {
			request.getRequestDispatcher(pageName).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
