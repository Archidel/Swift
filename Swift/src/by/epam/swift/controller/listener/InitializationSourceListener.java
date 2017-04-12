package by.epam.swift.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.command.CommandProvider;
import by.epam.swift.controller.configuration.CommandName;

/**Listener for initialization and destroy source (connection pool)
 * @author Archangel
 */
public class InitializationSourceListener implements ServletContextListener  {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.INITIALIZATION_SOURCE.name());
		command.executeCommand(null, null);		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.DESTROY_SOURCE.name());
		command.executeCommand(null, null);	
	}

}
