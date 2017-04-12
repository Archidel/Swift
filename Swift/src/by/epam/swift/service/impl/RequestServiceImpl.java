package by.epam.swift.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.dao.AgreementDAO;
import by.epam.swift.dao.RequestServiceDAO;
import by.epam.swift.dao.TariffDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

public class RequestServiceImpl implements RequestService {

	@Override
	public List<RequestOnService> getRequestList() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		List<RequestOnService> list = null;
/*		
		try {
//			list = requestServiceDAO.getRequestList();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}*/
		
		return list;
	}

	@Override
	public RequestOnService getRequestOnServiceById(int idRequest) throws ServiceException {
		if(!ValidationData.validInteger(idRequest)){
			throw new ServiceException("Incorrent id request");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		RequestOnService requestOnService = null;
	/*	
		try {
			requestOnService = requestServiceDAO.getRequestOnServiceById(idRequest);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}*/
		
		return requestOnService;
	}

	@Override
	public void removeRequestOnService(int idRequestOnService) throws ServiceException {
		/*if(!ValidationData.validInteger(idRequestOnService)){
			throw new ServiceException("Incorrent id request");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		
		try {
//			requestServiceDAO.removeRequestOnService(idRequestOnService);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		*/
	}

	@Override
	public void applyRequest(int idRequestOnService, int idUser, String typeTariff) throws ServiceException {
		if(!ValidationData.validRequest(idRequestOnService, idUser, typeTariff)){
			throw new ServiceException("Incorrent idRequest, idUser or type tariff");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		RequestServiceDAO requestServiceDAO = daoFactory.getRequestServiceDAO();
		
		/*try {
			if(Type.INTERNET == Type.valueOf(typeTariff.toUpperCase())){
				requestServiceDAO.applyInternetRequest(idRequestOnService, idUser);
			}
			
			if(Type.DIGITAL_TV == Type.valueOf(typeTariff.toUpperCase())){
				requestServiceDAO.applyDigitalTVRequest(idRequestOnService, idUser);
			}

			if(Type.TELEPHONY == Type.valueOf(typeTariff.toUpperCase())){
				requestServiceDAO.applyTelephonyRequest(idRequestOnService, idUser);
			}			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}*/
	}

	@Override
	public void makeRequestOnService(String title, String type, String datePeriod, String serviceAction, int idUser) throws ServiceException {
		if(!ValidationData.validRequest(title, type, datePeriod, serviceAction)){
			throw new ServiceException("Incorrent data for make request no serivce");
		}
		
		title = title.split("\\[")[0].trim().toLowerCase();
		
		boolean action = false;
		if(serviceAction.equalsIgnoreCase("ENABLE")){
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
			int idAgreement = agreementDAO.getIdAgreementByUserId(idUser);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			requestServiceDAO.makeRequestOnService(idAgreement, idTariff, sdf.format(new Date()), action);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
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
			int idAgreement = agreementDAO.getIdAgreementByUserId(idUser);
			list = requestServiceDAO.getRequestOnServiceList(idAgreement, begin, offset);
		} catch (DAOException e) {
			throw new ServiceException(e);
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
			throw new ServiceException(e);
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
			throw new ServiceException(e);
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
			throw new ServiceException(e);
		}
		
		return numberEntries;
	}

}
