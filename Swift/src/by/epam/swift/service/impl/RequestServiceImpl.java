package by.epam.swift.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.RequestOnService;
import by.epam.swift.bean.Tariff;
import by.epam.swift.bean.User;
import by.epam.swift.dao.AgreementDAO;
import by.epam.swift.dao.RequestServiceDAO;
import by.epam.swift.dao.TariffDAO;
import by.epam.swift.dao.UserDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

/** The class implements the interface {@link RequestService}
 * @author Archangel
 */
public class RequestServiceImpl implements RequestService {

	@Override
	public RequestOnService getRequestOnServiceById(int idRequest) throws ServiceException {
		if(!ValidationData.validInteger(idRequest)){
			throw new ServiceException("Incorrent id request");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		RequestOnService requestOnService = null;
		
		try {
			requestOnService = requestServiceDAO.getRequestOnServiceById(idRequest);
		} catch (DAOException e) {
			throw new ServiceException("Error getting request on service by id", e);
		}
		
		return requestOnService;
	}

	@Override
	public void removeRequestOnService(int idRequestOnService) throws ServiceException {
		if(!ValidationData.validInteger(idRequestOnService)){
			throw new ServiceException("Incorrent id request");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		
		try {
			requestServiceDAO.removeRequestOnService(idRequestOnService);
		} catch (DAOException e) {
			throw new ServiceException("Removal request on service error", e);
		}
		
	}

	@Override
	public void makeRequestOnService(String title, String type, String serviceAction, int idUser, Date blockDate) throws ServiceException {
		if(!ValidationData.validRequest(title, type, serviceAction)){
			throw new ServiceException("Incorrent data for make request no serivce");
		}
		
		Date currentDate = new Date();
		if((blockDate != null) && (blockDate.compareTo(currentDate) == 1)){
			throw new ServiceException("This user is blocked and can't to create request on service");
		}
		
		title = title.split("\\[")[0].trim().toLowerCase();
		boolean action = false;
		if(serviceAction.equalsIgnoreCase("ENABLE") || serviceAction.equalsIgnoreCase("Включить")){
			action = true;
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		TariffDAO tariffDAO = daoFactory.getTariffDAO();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		
		try {
			int idTariffType = tariffDAO.getIdTariffTypeByTitle(type);		
			int idTariff = tariffDAO.getIdTariffByTitleAndType(title, idTariffType);
			
			if(idTariff == 0){
				throw new ServiceException("This tariff not found");
			}
			
			if(!action){
				boolean tariffIsFound = false;
				List<Integer> list = requestServiceDAO.getUserTariffList(idUser);
				for(int i = 0; i < list.size(); i++){
					if(list.get(i) == idTariff){
						tariffIsFound = true;
						break;
					}
				}
				if(!tariffIsFound){
					throw new ServiceException("The user does not have this tariff");
				}
			}
			
			int idAgreement = agreementDAO.getIdAgreementByUserId(idUser);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			requestServiceDAO.makeRequestOnService(idAgreement, idTariff, sdf.format(new Date()), action);
		} catch (DAOException e) {
			throw new ServiceException("Erorr creating request on service", e);
		}
	}

	@Override
	public List<RequestOnService> getRequestOnServiceList(int idUser, int numberPage) throws ServiceException {
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Icorrent number of page");
		}
		
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Icorrent id user");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = factory.getRequestServiceDAO();
		AgreementDAO agreementDAO = factory.getAgreementDAO();
		
		List<RequestOnService> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;
		
		try {
			int idAgreement = agreementDAO.getIdAgreementByUserIdAccepted(idUser);
			list = requestServiceDAO.getRequestOnServiceList(idAgreement, begin, offset);
		} catch (DAOException e) {
			throw new ServiceException("Error getting list of request on service", e);
		}
		
		return list;
	}

	@Override
	public int getAmountEntriesRequestList(int idUser) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw  new ServiceException("Incorrent user id");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = factory.getRequestServiceDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = requestServiceDAO.getAmountEntriesRequestList(idUser);
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of request", e);
		}
		
		return numberEntries;
	}

	@Override
	public List<RequestOnService> getRequestOnServiceList(int numberPage) throws ServiceException {
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Icorrent number of page");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = factory.getRequestServiceDAO();
		
		List<RequestOnService> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;
		
		try {
			list = requestServiceDAO.getRequestOnServiceList(begin, offset);
		} catch (DAOException e) {
			throw new ServiceException("Error getting list of request on service", e);
		}
		
		return list;
	}

	@Override
	public int getAmountEntriesRequestList() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = factory.getRequestServiceDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = requestServiceDAO.getAmountEntriesRequestList();
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of request on service", e);
		}
		
		return numberEntries;
	}

	@Override
	public void acceptRequestOnService(int idRequest, int idAdmin, int idUser, boolean action) throws ServiceException {
		if(!ValidationData.validInteger(idRequest)){
			throw new ServiceException("Icorrent id request");
		}
		
		if(!ValidationData.validInteger(idAdmin)){
			throw new ServiceException("Icorrent id admin");
		}
		
		if(!ValidationData.validInteger(idAdmin)){
			throw new ServiceException("Icorrent id user");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		TariffDAO tariffDAO = daoFactory.getTariffDAO();
		
		try {
			RequestOnService requestOnService = requestServiceDAO.getRequestOnServiceById(idRequest);
			User user = userDAO.getUserById(idUser);
			Tariff tariff = tariffDAO.getTariffById(requestOnService.getIdTariff());

			if(user.getBalance() < tariff.getPrice()){
				throw new ServiceException("Not enough money");
			}
			
			Agreement agreement = agreementDAO.getAgreementById(requestOnService.getIdAgreement());
			requestServiceDAO.acceptRequestOnService(agreement.getIdUser(), requestOnService.getIdTariff(), action, idAdmin, tariff.getPrice());
			requestServiceDAO.removeRequestOnService(idRequest);
		} catch (DAOException e) {
			throw new ServiceException("Error accepted request on service", e);
		}
	}

}
