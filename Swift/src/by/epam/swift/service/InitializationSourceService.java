package by.epam.swift.service;

import by.epam.swift.service.exception.ServiceException;;

public interface InitializationSourceService {
	void initSource() throws ServiceException;
	void destroySource() throws ServiceException;
}
