package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.dao.exception.DAOException;

/**Interface tariff DAO.
 * @author Archangel
 */
public interface TariffDAO {
	/** Method returns a list of tariffs for which the status is active for user
	 * @param begin
	 * @param offset
	 * @param tariffType
	 * @return List {@link Tariff}
	 * @throws DAOException
	 */
	List<Tariff> getListTariffActiveStatus(int begin, int offset, String tariffType) throws DAOException;
	/** Method returns a list of tariffs for which the status is active for user
	 * @return List {@link Tariff}
	 * @throws DAOException
	 */
	List<Tariff> getListTariffActiveStatus() throws DAOException;
	/**Get all tariff sheets with different statuses
	 * @param begin
	 * @param offset
	 * @param tariffType
	 * @return List <{@link Tariff}
	 * @throws DAOException
	 */
	List<Tariff> getListTariffInactiveStatus(int begin, int offset, String tariffType) throws DAOException;
	/** Get type of tariff list 
	 * @return List String
	 * @throws DAOException
	 */
	List<String> getListTypeOfTariff() throws DAOException;
	/** Get title of tariff 
	 * @return List String
	 * @throws DAOException
	 */
	List<String> getListTitleOfTariff() throws DAOException;
	/**Search by name and type of tariff
	 * @param tariff
	 * @param begin
	 * @param offset
	 * @return List {@link Tariff}
	 * @throws DAOException
	 */
	List<Tariff> searchTariff(String tariff, int begin, int offset) throws DAOException;
	/**The method updates the data of this tariff by id
	 * @param tariff
	 * @throws DAOException
	 */
	void editTariff(Tariff tariff) throws DAOException;
	/** Add new tariff
	 * @param title
	 * @param description
	 * @param type
	 * @param price
	 * @throws DAOException
	 */
	void addTariff(String title, String description, int type, double price) throws DAOException;
	/** Add new type of tariff
	 * @param tariffType
	 * @throws DAOException
	 */
	void addTariffType(String tariffType) throws DAOException;
	/** Remove tariff by ID
	 * @param idTariff
	 * @param tariffStatus
	 * @throws DAOException
	 */
	void removeTariff(int idTariff, boolean tariffStatus) throws DAOException;
	/** Get ID tariff By title and type of tariff
	 * @param title
	 * @param type
	 * @return int
	 * @throws DAOException
	 */
	int getIdTariffByTitleAndType(String title, int type) throws DAOException;
	/** The method returns the number of tariff which the status is active by type of tariff for user
	 * @param tariffType
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesListTariffActiveStatus(String tariffType) throws DAOException;
	/** The method returns the number of tariff with different statuses
	 * @param tariffType
	 * @return int 
	 * @throws DAOException
	 */
	int getAmountEntriesListTariffInactiveStatus(String tariffType) throws DAOException;
	/** Get tariff ID by title and type of tariff
	 * @param title
	 * @return int 
	 * @throws DAOException
	 */
	int getIdTariffTypeByTitle(String title) throws DAOException;
	/** The method returns the number of found tariffs in the search
	 * @param tariff
	 * @return
	 * @throws DAOException
	 */
	int getAmountEntriesSearchTariff(String tariff) throws DAOException;
	/** Get tariff status by tariif ID
	 * @param idTariff
	 * @return boolean
	 * @throws DAOException
	 */
	boolean getTariffStatusById(int idTariff) throws DAOException;
	/** Get title of tariff by tariff ID
	 * @param idTariff
	 * @return String
	 * @throws DAOException
	 */
	String getTariffTitleById(int idTariff) throws DAOException;
	/** Get tariff by tariff ID
	 * @param idTariff
	 * @return {@link Tariff}
	 * @throws DAOException
	 */
	Tariff getTariffById(int idTariff) throws DAOException;
}
