package by.epam.swift.controller.command.agreement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Agreement;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for  get agreement list.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetAgreementList implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetAgreementList.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		ServiceFactory factory = ServiceFactory.getInstance();
		AgreementService agreementService = factory.getAgreementService();
		
		try {
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = agreementService.getAmountEntriesListAgreement();
			request.setAttribute(AttributeName.AMOUNT_RESULT, numberEntries);
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);

			List<Agreement> list = agreementService.getAgreementList(numberPage);
			request.setAttribute(AttributeName.LIST, list);
			request.getRequestDispatcher(PageName.GET_AGREEMENT_LIST).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
