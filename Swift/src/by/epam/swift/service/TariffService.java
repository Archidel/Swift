package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.service.exception.ServiceException;

public interface TariffService {
	/** Search by name of tariff
	 * @param tariff
	 * @param numberPage
	 * @return  List {@link Tariff}
	 * @throws ServiceException
	 */
	List<Tariff> searchTariff(String tariff, int numberPage) throws ServiceException;
	/** The method returns the number of found tariffs in the search
	 * @param tariff
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesSearchTariff(String tariff) throws ServiceException;
	/** Add new type of tariff
	 * @param tariffType
	 * @throws ServiceException
	 */
	void addTariffType(String tariffType) throws ServiceException;
	/**  Method returns a list of tariffs for which the status is active for user
	 * @param numberPage
	 * @param tariffType
	 * @return List {@link Tariff}
	 * @throws ServiceException
	 */
	List<Tariff> getListTariffActiveStatus(int numberPage, String tariffType) throws ServiceException;
	/** Method returns a list of tariffs for which the status is active for user
	 * @return List {@link Tariff}
	 * @throws ServiceException
	 */
	List<Tariff> getListTariffActiveStatus() throws ServiceException;
	/** Get all tariff sheets with different statuses
	 * @param numberPage
	 * @param tariffType
	 * @return List <{@link Tariff}
	 * @throws ServiceException
	 */
	List<Tariff> getListTariffInactiveStatus(int numberPage, String tariffType) throws ServiceException;
	/** Get type of tariff list 
	 * @return List String
	 * @throws ServiceException
	 */
	List<String> getListTypeOfTariff() throws ServiceException;
	/** Get title of tariff 
	 * @return List String
	 * @throws ServiceException
	 */
	List<String> getListTitleOfTariff() throws ServiceException;
	/** Get tariff by tariff ID
	 * @param idTariff int
	 * @return {@link Tariff}
	 * @throws ServiceException
	 */
	Tariff getTariffById(int idTariff) throws ServiceException;
	/** Get tariff by tariff ID
	 * @param idTariff String
	 * @return {@link Tariff}
	 * @throws ServiceException
	 */
	Tariff getTariffById(String idTariff) throws ServiceException;
	/** Get title of tariff by tariff ID
	 * @param idTariff
	 * @return String
	 * @throws ServiceException
	 */
	String getTariffTitleById(int idTariff) throws ServiceException;
	/** The method updates the data of this tariff by id
	 * @param idTariff
	 * @param title
	 * @param description
	 * @param price
	 * @throws ServiceException
	 */
	void editTariff(int idTariff, String title, String description, String price) throws ServiceException;
	/** Add new tariff
	 * @param title
	 * @param description
	 * @param type
	 * @param price
	 * @throws ServiceException
	 */
	void addTariff(String title, String description,String type, String price) throws ServiceException;
	/** Remove tariff by tariff id
	 * @param idTariff
	 * @throws ServiceException
	 */
	void removeTariff(int idTariff) throws ServiceException;
	/** The method returns the number of tariff which the status is active by type of tariff for user
	 * @param tariffType
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesListTariffActiveStatus(String tariffType) throws ServiceException;	
	/** Get tariff ID by title and type of tariff
	 * @param tariffType
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesListTariffInactiveStatus(String tariffType) throws ServiceException;
}
