package by.epam.swift.dao;

import by.epam.swift.dao.exception.DAOException;;

public interface InitializationSourceDAO {
	void initSource() throws DAOException;
	void destroySource() throws DAOException;
}
