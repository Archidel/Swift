package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.dao.exception.DAOException;

public interface UserDAO {
	boolean signIn(String login, int password) throws DAOException;
	void signUp(User user) throws DAOException;
	User getUserByLoginAndPassword(String login, String password) throws DAOException;
	User getUserById(int idUser) throws DAOException;
	void editProfile(User user) throws DAOException;
	List<User> getUserList() throws DAOException;
	void setBlock(int idUser, String date) throws DAOException;
	void removeBlock(int idUser) throws DAOException;
	double getBalance(int idUser) throws DAOException;
	void addBalance(double balance, int idUser) throws DAOException;
	int getAmountEntriesListUser() throws DAOException;
}
