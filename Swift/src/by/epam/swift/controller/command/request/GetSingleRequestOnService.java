package by.epam.swift.controller.command.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.RequestOnService;
import by.epam.swift.bean.Tariff;
import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for get more info about request on service.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetSingleRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetSingleRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int idRequest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
		UserService userService = factory.getUserService();
		AgreementService agreementService = factory.getAgreementService();
		TariffService tariffService = factory.getTariffService();
		
		try {
			RequestOnService requestOnService = requestService.getRequestOnServiceById(idRequest);
			int idAgreement = requestOnService.getIdAgreement();
			Agreement agreement = agreementService.getAgreementById(idAgreement);
			User user = userService.getUserById(agreement.getIdUser());
			Tariff tariff = tariffService.getTariffById(requestOnService.getIdTariff());
			request.setAttribute(AttributeName.TARIFF, tariff);
			request.setAttribute(AttributeName.USER, user);
			request.setAttribute(AttributeName.MORE, requestOnService);
			request.getRequestDispatcher(PageName.GET_SINGLE_REQUEST_ON_SERVICE_PAGE).forward(request, response);	
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);		
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);		
		}		
	}

}
