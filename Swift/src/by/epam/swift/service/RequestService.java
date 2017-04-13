package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.service.exception.ServiceException;

public interface RequestService {
	RequestOnService getRequestOnServiceById(int idRequestOnService) throws ServiceException;
	void removeRequestOnService(int idRequestOnService) throws ServiceException;
	void makeRequestOnService(String title, String type, String datePeriod, String serviceAction, int idUser) throws ServiceException;	
	List<RequestOnService> getRequestOnServiceList(int idUser, int numberPage) throws ServiceException;
	int getAmountEntriesRequestList(int idUser) throws ServiceException;
	List<RequestOnService> getRequestOnServiceList(int numberPage) throws ServiceException;
	int getAmountEntriesRequestList() throws ServiceException;
	void acceptRequestOnService(int idRequest, int idUser, boolean action) throws ServiceException;
}
