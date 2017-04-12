package by.epam.swift.dao;


import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.dao.exception.DAOException;

public interface RequestServiceDAO {
	void makeRequestOnService(int idAgreement, int idTariff, String date, boolean serviceAction) throws DAOException;		
	List<RequestOnService> getRequestOnServiceList(int idAgrement, int begin, int offset) throws DAOException;
	List<RequestOnService> getRequestOnServiceList(int begin, int offset) throws DAOException;
	int getAmountEntriesRequestList(int idUser) throws DAOException;
	int getAmountEntriesRequestList() throws DAOException;
}
