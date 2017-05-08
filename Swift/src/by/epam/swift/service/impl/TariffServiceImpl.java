package by.epam.swift.service.impl;

import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.dao.TariffDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

/** The class implements the interface {@link TariffService}
 * @author Archangel
 */
public class TariffServiceImpl implements TariffService {

	@Override
	public List<Tariff> searchTariff(String tariff, int numberPage) throws ServiceException {
		if(!ValidationData.validString(tariff)){
			throw new ServiceException("Incorrent search tariff");
		}
		
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Icorrent number of page");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		
		List<Tariff> list = null;
		int offset = numberPage * 10;
		int begin = offset - 10;
		
		try {
			list = tariffDAO.searchTariff(tariff, begin, offset);
		} catch (DAOException e) {
			throw new ServiceException("Error searching tariff", e);
		}
		
		return list;
	}

	@Override
	public int getAmountEntriesSearchTariff(String tariff) throws ServiceException {
		if(!ValidationData.validString(tariff)){
			throw new ServiceException("Incorrent search tariff");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = tariffDAO.getAmountEntriesSearchTariff(tariff);
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries search tariff", e);
		}
		
		return numberEntries;
	}

	@Override
	public void addTariffType(String tariffType) throws ServiceException {
		if(!ValidationData.validString(tariffType)){
			throw new ServiceException("Incorrent tariff type");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		
		try {
			tariffDAO.addTariffType(tariffType);
		} catch (DAOException e) {
			throw new ServiceException("Error add type of tariff", e);
		}
		
	}

	@Override
	public List<Tariff> getListTariffActiveStatus(int numberPage, String tariffType) throws ServiceException {
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Iccorrent number of page");
		}
		
		if(!ValidationData.validString(tariffType)){
			throw new ServiceException("Incorrent tariff type");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		List<Tariff> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;	
		
		try {
			list = tariffDAO.getListTariffActiveStatus(begin, offset, tariffType);
		} catch (DAOException e) {
			throw new ServiceException("Error getting tariff active status", e);
		}
		
		return list;
	}
	
	@Override
	public List<Tariff> getListTariffInactiveStatus(int numberPage, String tariffType) throws ServiceException {
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Icorrent number of page");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		TariffDAO tariffDAO = daoFactory.getTariffDAO();
		List<Tariff> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;	
		
		try {
			list = tariffDAO.getListTariffInactiveStatus(begin, offset, tariffType);
		} catch (DAOException e) {
			throw new ServiceException("Error getting list of tariff inactive status", e);
		}
		
		return list;
	}

	@Override
	public Tariff getTariffById(int idTariff) throws ServiceException {
		if(!ValidationData.validInteger(idTariff)){
			throw new ServiceException("Incorrent id tariff");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		Tariff tariff = null;
		
		try {
			tariff = tariffDAO.getTariffById(idTariff);
		} catch (DAOException e) {
			throw new ServiceException("Error getting by id", e);
		}
		
		return tariff;
	}
	
	@Override
	public String getTariffTitleById(int idTariff) throws ServiceException {
		if(!ValidationData.validInteger(idTariff)){
			throw new ServiceException("Incorrent id tariff");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		String title = null;
		
		try {
			title = tariffDAO.getTariffTitleById(idTariff);
		} catch (DAOException e) {
			throw new ServiceException("Error getting tariff title by id", e);
		}
		
		return title;
	}

	@Override
	public void editTariff(int idTariff, String title, String description, String price) throws ServiceException {
		if(!ValidationData.validTariff(title, description, price)){
			throw new ServiceException("Incorrent data for edit tariff");
		}
		
		Tariff tariff = new Tariff();
		tariff.setId(idTariff);
		tariff.setTitle(title);
		tariff.setDescription(description);
		tariff.setPrice(Double.parseDouble(price));
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		
		try {
			tariffDAO.editTariff(tariff);
		} catch (DAOException e) {
			throw new ServiceException("Error edit tariff", e);
		}
	}

	@Override
	public void addTariff(String title, String description, String type, String price) throws ServiceException {
		if(!ValidationData.validTariff(title, description, price)){
			throw new ServiceException("Inccorent tariff data");
		}
		
		double dPrice = Double.parseDouble(price);
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		
		try {
			int idTariffType = tariffDAO.getIdTariffTypeByTitle(type);
			tariffDAO.addTariff(title, description, idTariffType, dPrice);
		} catch (DAOException e) {
			throw new ServiceException("Error add new tariff", e);
		}
		
	}
	
	@Override
	public void removeTariff(int idTariff) throws ServiceException {
		if(!ValidationData.validInteger(idTariff)){
			throw new ServiceException("Inccorent id tariff");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		
		try {
			boolean status = tariffDAO.getTariffStatusById(idTariff);
			tariffDAO.removeTariff(idTariff, status);
		} catch (DAOException e) {
			throw new ServiceException("Remove tariff error", e);
		}
		
	}

	@Override
	public int getAmountEntriesListTariffActiveStatus(String tariffType) throws ServiceException {
		if(!ValidationData.validString(tariffType)){
			throw new ServiceException("Incorrent tariff type");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = tariffDAO.getAmountEntriesListTariffActiveStatus(tariffType);
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of tariff active status", e);
		}
		
		return numberEntries;
	}

	@Override
	public int getAmountEntriesListTariffInactiveStatus(String tariffType) throws ServiceException {
		if(!ValidationData.validString(tariffType)){
			throw new ServiceException("Incorrent tariff type");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = tariffDAO.getAmountEntriesListTariffInactiveStatus(tariffType);
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of tariff inactive status", e);
		}
		
		return numberEntries;
	}

	@Override
	public List<String> getListTypeOfTariff() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		List<String> list = null;
		
		try {
			list = tariffDAO.getListTypeOfTariff();
		} catch (DAOException e) {
			throw new ServiceException("Error getting type of tariff", e);
		}
		
		return list;
	}

	@Override
	public List<String> getListTitleOfTariff() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		List<String> list = null;
		
		try {
			list = tariffDAO.getListTitleOfTariff();
		} catch (DAOException e) {
			throw new ServiceException("Error getting title of tariff list", e);
		}
		
		return list;
	}

	@Override
	public List<Tariff> getListTariffActiveStatus() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		TariffDAO tariffDAO = daoFactory.getTariffDAO();
		List<Tariff> list = null;
		
		try {
			list = tariffDAO.getListTariffActiveStatus();
		} catch (DAOException e) {
			throw new ServiceException("Error getting tairff activa status", e);
		}
		
		return list;
	}

	@Override
	public Tariff getTariffById(String idTariff) throws ServiceException {
		if(!ValidationData.validInteger(idTariff)){
			throw new ServiceException("Incorrent id tariff");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		TariffDAO tariffDAO = factory.getTariffDAO();
		int id = Integer.parseInt(idTariff);
		Tariff tariff = null;
		
		try {
			tariff = tariffDAO.getTariffById(id);
		} catch (DAOException e) {
			throw new ServiceException("Error getting tariff by id", e);
		}
		
		return tariff;
	}

}
