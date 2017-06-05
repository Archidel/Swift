package by.epam.swift.controller.command.agreement;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for  create new agreement.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class CreateAgreement implements Command {
	private static final Logger LOGGER = Logger.getLogger(CreateAgreement.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		AgreementService agreementService = factory.getAgreementService();
		
		try {
			agreementService.createAgreement(user);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_CREATE_AGREEMENT_SUCCESS);				
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_CREATE_AGREEMENT_ERROR);
			LOGGER.error(e);
		}
	}

}
