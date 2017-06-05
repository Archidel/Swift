package by.epam.swift.controller.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.command.CommandName;
import by.epam.swift.controller.command.CommandProvider;

/**Listener for initialization and destroy source (connection pool)
 * @author Archangel
 */
public class InitializationSourceListener implements ServletContextListener  {
	private static final Logger LOGGER = Logger.getLogger(InitializationSourceListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.INITIALIZATION_SOURCE.name());
		try {
			command.executeCommand(null, null);
		} catch (IOException e) {
			LOGGER.error(e);
		}		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.DESTROY_SOURCE.name());
		try {
			command.executeCommand(null, null);
		} catch (IOException e) {
			LOGGER.error(e);
		}	
	}

}
