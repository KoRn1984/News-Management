package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import by.itacademy.matveenko.jd2.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToLoginationPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("webapp/authorization.jsp").forward(request, response);
	}

}
