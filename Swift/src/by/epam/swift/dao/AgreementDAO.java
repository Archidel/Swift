package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.dao.exception.DAOException;

public interface AgreementDAO {
	void createAgreement(int idUser, String date) throws DAOException;
	int getIdAgreementByUserId(int idUser) throws DAOException;
	int getIdAgreementByUserIdAccepted(int idUser) throws DAOException;
	
	List<Agreement> getAgreementList(int begin, int offset) throws DAOException;
	int getAmountEntriesListAgreement() throws DAOException;
	Agreement getAgreementById(int idAgreement) throws DAOException;
	void removeAgreement(int idAgreement, int idAdmin) throws DAOException;
	void acceptAgreement(int idAgreement, int idAdmin) throws DAOException;
}
