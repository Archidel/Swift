package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.service.exception.ServiceException;

public interface TariffService {
	List<Tariff> searchTariff(String tariff, int numberPage) throws ServiceException;

	int getAmountEntriesSearchTariff(String tariff) throws ServiceException;
	void addTariffType(String tariffType) throws ServiceException;
	
	List<Tariff> getListTariffActiveStatus(int numberPage, String tariffType) throws ServiceException;
	List<Tariff> getListTariffActiveStatus() throws ServiceException;
	List<Tariff> getListTariffInactiveStatus(int numberPage, String tariffType) throws ServiceException;
	List<String> getListTypeOfTariff() throws ServiceException;
	List<String> getListTitleOfTariff() throws ServiceException;
	
	Tariff getTariffById(int idTariff) throws ServiceException;
	Tariff getTariffById(String idTariff) throws ServiceException;

	String getTariffTitleById(int idTariff) throws ServiceException;
	void editTariff(int idTariff, String title, String description, String price) throws ServiceException;
	void addTariff(String title, String description,String type, String price) throws ServiceException;
	void removeTariff(int idTariff) throws ServiceException;
	
	int getAmountEntriesListTariffActiveStatus(String tariffType) throws ServiceException;	
	int getAmountEntriesListTariffInactiveStatus(String tariffType) throws ServiceException;
	
}
