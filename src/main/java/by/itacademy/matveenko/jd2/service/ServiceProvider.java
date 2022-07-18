package by.itacademy.matveenko.jd2.service;

import by.itacademy.matveenko.jd2.service.ServiceProvider;
import by.itacademy.matveenko.jd2.service.UserService;
import by.itacademy.matveenko.jd2.service.impl.UserServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final UserService userService = new UserServiceImpl();
	
	public UserService getUserService() {
		return userService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
