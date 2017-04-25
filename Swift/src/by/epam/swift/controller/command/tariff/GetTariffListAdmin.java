package by.epam.swift.controller.command.tariff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Tariff;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for get tariff list for administration with different status.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetTariffListAdmin implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetTariffListAdmin.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		String tariffType = request.getParameter(ParameterName.TARIFF_TYPE);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			request.setAttribute(AttributeName.TARIFF_TYPE, tariffType);
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = tariffService.getAmountEntriesListTariffInactiveStatus(tariffType);
			request.setAttribute(AttributeName.AMOUNT_RESULT, numberEntries);
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			List<Tariff> list = tariffService.getListTariffInactiveStatus(numberPage, tariffType);
			request.setAttribute(AttributeName.LIST, list);
			request.getRequestDispatcher(PageName.TARIFF_LIST_ADMIN_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
