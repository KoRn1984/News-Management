package by.itacademy.matveenko.jd2.controller.impl;

import java.util.concurrent.atomic.AtomicReference;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.impl.SQLUserDao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import static by.itacademy.matveenko.jd2.bean.UserRole.ADMIN;
import static by.itacademy.matveenko.jd2.bean.UserRole.USER;

@WebListener
public class ContextListener implements ServletContextListener {
    
    private AtomicReference<SQLUserDao> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new SQLUserDao());

        dao.get().add(new NewUserInfo(1, "KoRn", "KoRn1984", ADMIN));
        dao.get().add(new NewUserInfo(2, "Yury", "123456", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
