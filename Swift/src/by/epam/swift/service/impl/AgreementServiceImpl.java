package by.epam.swift.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.User;
import by.epam.swift.dao.AgreementDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

/** The class implements the interface {@link AgreementService}
 * @author Archangel
 */
public class AgreementServiceImpl implements AgreementService {

	@Override
	public void createAgreement(User user) throws ServiceException {
		if(!ValidationData.validUserFull(user)){
			throw new ServiceException("Not enought information for createing agreement");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			agreementDAO.createAgreement(user.getId(), sdf.format(new Date()));
		} catch (DAOException e) {
			throw new ServiceException("",e);
		}
		
	}

	@Override
	public List<Agreement> getAgreementList(int numberPage) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = factory.getAgreementDAO();
		List<Agreement> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;
		
		try {
			list = agreementDAO.getAgreementList(begin, offset);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return list;
	}

	@Override
	public int getAmountEntriesListAgreement() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = factory.getAgreementDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = agreementDAO.getAmountEntriesListAgreement();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return numberEntries;
	}

	@Override
	public Agreement getAgreementById(int idAgreement) throws ServiceException {
		if(!ValidationData.validInteger(idAgreement)){
			throw new ServiceException("Incorrent id agreement");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		Agreement agreement = null;
		
		try {
			agreement = agreementDAO.getAgreementById(idAgreement);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return agreement;
	}

	@Override
	public void removeAgreement(int idAgreement, int idAdmin) throws ServiceException {
		if(!ValidationData.validInteger(idAdmin)){
			throw new ServiceException("Incorrent id admin");
		}
		
		if(!ValidationData.validInteger(idAgreement)){
			throw new ServiceException("Incorrent id agreement");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		
		try {
			agreementDAO.removeAgreement(idAgreement, idAdmin);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public void acceptAgreement(int idAgreement, int idAdmin) throws ServiceException {
		if(!ValidationData.validInteger(idAdmin)){
			throw new ServiceException("Incorrent id admin");
		}
		
		if(!ValidationData.validInteger(idAgreement)){
			throw new ServiceException("Incorrent id agreement");
		}
	
		DAOFactory daoFactory = DAOFactory.getInstance();
		AgreementDAO agreementDAO = daoFactory.getAgreementDAO();
		
		try {
			agreementDAO.acceptAgreement(idAgreement, idAdmin);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
