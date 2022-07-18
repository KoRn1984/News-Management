package by.itacademy.matveenko.jd2.service.impl;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.DaoProvider;
import by.itacademy.matveenko.jd2.dao.UserDao;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.UserService;
import by.itacademy.matveenko.jd2.util.validation.UserDataValidation;
import by.itacademy.matveenko.jd2.util.validation.ValidationProvider;

public class UserServiceImpl implements UserService{

	private final UserDao userDao = DaoProvider.getInstance().getUserDao();
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();
	
	@Override
	public NewUserInfo logination(String login, String password) throws ServiceException {
		
		if(!userDataValidation.checkAuthData(login, password)) {
			throw new ServiceException("login ...... ");
		}
				
		try {
			return userDao.logination(login, password);
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public NewUserInfo registration(NewUserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
