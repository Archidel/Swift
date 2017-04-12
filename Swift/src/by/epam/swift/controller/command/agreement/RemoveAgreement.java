package by.epam.swift.controller.command.agreement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class RemoveAgreement implements Command {
	private static final Logger LOGGER = Logger.getLogger(RemoveAgreement.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);

		int idAdmin = user.getId();
		int idAgreement = Integer.parseInt(request.getParameter(ParameterName.AGREEMENT_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		AgreementService agreementService = factory.getAgreementService();
		
		try {
			agreementService.removeAgreement(idAgreement, idAdmin);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		
		try {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_AGREEMENT_LIST);				
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

}
