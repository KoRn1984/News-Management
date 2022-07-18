package by.itacademy.matveenko.jd2.dao.impl;

import java.util.ArrayList;
import java.util.List;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.UserDao;

public class SQLUserDao implements UserDao{
	
	private final List<NewUserInfo> store = new ArrayList<>();
	
		
	    public NewUserInfo getById(int id) {

	    	NewUserInfo result = new NewUserInfo();
	        result.setId(-1);

	        for (NewUserInfo user : store) {
	            if (user.getId() == id) {
	                result = user;
	            }
	        }
	        return result;
	    }

	    public NewUserInfo getUserByLoginPassword(final String login, final String password) {

	    	NewUserInfo result = new NewUserInfo();
	        result.setId(-1);

	        for (NewUserInfo user : store) {
	            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
	                result = user;
	            }
	        }
	        return result;
	    }

	    public boolean add(final NewUserInfo user) {

	        for (NewUserInfo nui : store) {
	            if (nui.getLogin().equals(user.getLogin()) && nui.getPassword().equals(user.getPassword())) {
	                return false;
	            }
	        }
	        return store.add(user);
	    }

	    public UserRole getRoleByLoginPassword(final String login, final String password) {
	    	UserRole result = UserRole.UNKNOWN;

	        for (NewUserInfo user : store) {
	            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
	                result = user.getRole();
	            }
	        }
	        return result;
	    }

	    public boolean userIsExist(final String login, final String password) {

	        boolean result = false;

	        for (NewUserInfo user : store) {
	            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
	                result = true;
	                break;
	            }
	        }
	        return result;
	    }

	@Override
	public NewUserInfo logination(String login, String password) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewUserInfo registration(NewUserInfo user) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
