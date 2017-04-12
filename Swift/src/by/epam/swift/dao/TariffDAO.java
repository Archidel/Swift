package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.dao.exception.DAOException;

public interface TariffDAO {
	List<Tariff> getListTariffActiveStatus(int begin, int offset, String tariffType) throws DAOException;
	List<Tariff> getListTariffActiveStatus() throws DAOException;
	List<Tariff> getListTariffInactiveStatus(int begin, int offset, String tariffType) throws DAOException;
	List<String> getListTypeOfTariff() throws DAOException;
	List<String> getListTitleOfTariff() throws DAOException;
	List<Tariff> searchTariff(String tariff, int begin, int offset) throws DAOException;

	void editTariff(Tariff tariff) throws DAOException;
	void addTariff(String title, String description, int type, double price) throws DAOException;
	void addTariffType(String tariffType) throws DAOException;
	void removeTariff(int idTariff, boolean tariffStatus) throws DAOException;

	int getIdTariffByTitleAndType(String title, int type) throws DAOException;
	int getAmountEntriesListTariffActiveStatus(String tariffType) throws DAOException;
	int getAmountEntriesListTariffInactiveStatus(String tariffType) throws DAOException;
	int getIdTariffTypeByTitle(String title) throws DAOException;
	int getAmountEntriesSearchTariff(String tariff) throws DAOException;

	boolean getTariffStatusById(int idTariff) throws DAOException;
	String getTariffTitleById(int idTariff) throws DAOException;
	Tariff getTariffById(int idTariff) throws DAOException;
}
