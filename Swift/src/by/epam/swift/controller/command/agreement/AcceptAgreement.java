package by.epam.swift.controller.command.agreement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/** Class for accept agreement.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class AcceptAgreement implements Command {
	private static final Logger LOGGER = Logger.getLogger(AcceptAgreement.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		int idAdmin = user.getId();
		int idAgreement = Integer.parseInt(request.getParameter(ParameterName.AGREEMENT_ID));
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AgreementService agreementService = serviceFactory.getAgreementService();
		
		try {
			agreementService.acceptAgreement(idAgreement, idAdmin);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_AGREEMENT_LIST);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
