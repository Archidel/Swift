package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.service.exception.ServiceException;

public interface UserService {
	User signIn(String login, String password) throws ServiceException;
	void signUp(User user, String password, String confirmPassword) throws ServiceException;
	User getUserById(int idUser) throws ServiceException;
	User editProfile(User user, String passport, String address) throws ServiceException;
	List<User> getUserList() throws ServiceException;
	void setBlock(int idUser, String date) throws ServiceException;
	void removeBlock(int idUser) throws ServiceException;
	
	double getBalance(String idUser) throws ServiceException;
	void addBalance(String balance, int idUser) throws ServiceException;
	int getAmountEntriesListUser() throws ServiceException;
}
