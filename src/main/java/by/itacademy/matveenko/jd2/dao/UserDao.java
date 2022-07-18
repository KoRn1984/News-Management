package by.itacademy.matveenko.jd2.dao;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.DaoException;

public interface UserDao {
	
	NewUserInfo logination(String login, String password) throws DaoException;
	NewUserInfo registration(NewUserInfo user) throws DaoException;
	
}
