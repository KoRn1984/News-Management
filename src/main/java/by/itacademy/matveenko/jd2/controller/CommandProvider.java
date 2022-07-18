package by.itacademy.matveenko.jd2.controller;

import java.util.HashMap;
import java.util.Map;

import by.itacademy.matveenko.jd2.controller.impl.DoLogination;
import by.itacademy.matveenko.jd2.controller.impl.DoRegistration;
import by.itacademy.matveenko.jd2.controller.impl.GoToLoginationPageCommand;
import by.itacademy.matveenko.jd2.controller.impl.GoToRegistrationPageCommand;
import by.itacademy.matveenko.jd2.controller.impl.WrongRequest;
import by.itacademy.matveenko.jd2.service.ServiceProvider;

public class CommandProvider {
	private static final CommandProvider instance = new CommandProvider();
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GO_TO_LOGINATION_PAGE, new GoToLoginationPageCommand());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPageCommand());
		commands.put(CommandName.DO_LOGINATION, new DoLogination());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	public static CommandProvider getInstance() {
		return instance;
	}
	
	public Command getCommand(String name) {
		CommandName commandName;
		Command command;
				
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = commands.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.WRONG_REQUEST);
		}
			
		return command;
	}
}
