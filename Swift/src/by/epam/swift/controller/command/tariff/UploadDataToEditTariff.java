package by.epam.swift.controller.command.tariff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Tariff;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for upload data to edit tariff form.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class UploadDataToEditTariff implements Command {
	private static final Logger LOGGER = Logger.getLogger(UploadDataToEditTariff.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int idTariff = Integer.parseInt(request.getParameter(ParameterName.TARIFF_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		TariffService tariffService = factory.getTariffService();
		
		try {
			Tariff tariff = tariffService.getTariffById(idTariff);
			request.setAttribute(AttributeName.MORE, tariff);
			request.getRequestDispatcher(PageName.EDIT_TARIFF_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
