package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.User;
import by.epam.swift.service.exception.ServiceException;

public interface AgreementService {
	void createAgreement(User user) throws ServiceException;
	List<Agreement> getAgreementList(int numberPage) throws ServiceException;
	int getAmountEntriesListAgreement() throws ServiceException;
	Agreement getAgreementById(int idAgreement) throws ServiceException;
	void removeAgreement(int idAgreement, int idAdmin) throws ServiceException;
	void acceptAgreement(int idAgreement, int idAdmin) throws ServiceException;
	
}
