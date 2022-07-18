package by.itacademy.matveenko.jd2.service;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.service.ServiceException;

public interface UserService {
	
	NewUserInfo logination(String login, String password) throws ServiceException;
	NewUserInfo registration(NewUserInfo user) throws ServiceException;

}
