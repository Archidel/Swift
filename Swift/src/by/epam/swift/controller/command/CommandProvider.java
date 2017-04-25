package by.epam.swift.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.agreement.AcceptAgreement;
import by.epam.swift.controller.command.agreement.CreateAgreement;
import by.epam.swift.controller.command.agreement.GetAgreementList;
import by.epam.swift.controller.command.agreement.GetSingleAgreement;
import by.epam.swift.controller.command.agreement.RemoveAgreement;
import by.epam.swift.controller.command.initialization.DestroySource;
import by.epam.swift.controller.command.initialization.InitializationSource;
import by.epam.swift.controller.command.localization.Localization;
import by.epam.swift.controller.command.news.AddNews;
import by.epam.swift.controller.command.news.EditNews;
import by.epam.swift.controller.command.news.RemoveNews;
import by.epam.swift.controller.command.news.GetNewsListAdmin;
import by.epam.swift.controller.command.news.GetNewsListUser;
import by.epam.swift.controller.command.news.UploadNewsDataToEdit;
import by.epam.swift.controller.command.request.AcceptRequestOnService;
import by.epam.swift.controller.command.request.GetRequestOnServiceListAdmin;
import by.epam.swift.controller.command.request.GetRequestOnServiceListUser;
import by.epam.swift.controller.command.request.GetSingleRequestOnService;
import by.epam.swift.controller.command.request.MakeRequestOnService;
import by.epam.swift.controller.command.request.RemoveRequestOnService;
import by.epam.swift.controller.command.request.UploadDataToRequestOnService;
import by.epam.swift.controller.command.news.GetSingleNews;
import by.epam.swift.controller.command.tariff.AddTariff;
import by.epam.swift.controller.command.tariff.AddTariffType;
import by.epam.swift.controller.command.tariff.EditTariff;
import by.epam.swift.controller.command.tariff.GetTariffListAdmin;
import by.epam.swift.controller.command.tariff.GetTariffListUser;
import by.epam.swift.controller.command.tariff.GetSingleTariff;
import by.epam.swift.controller.command.tariff.UploadDataToEditTariff;
import by.epam.swift.controller.command.tariff.RemoveTariff;
import by.epam.swift.controller.command.tariff.SearchTariff;
import by.epam.swift.controller.command.tariff.UploadDataToAddTariff;
import by.epam.swift.controller.command.user.EditProfile;
import by.epam.swift.controller.command.user.GetBalance;
import by.epam.swift.controller.command.user.GetUserList;
import by.epam.swift.controller.command.user.Logout;
import by.epam.swift.controller.command.user.SignIn;
import by.epam.swift.controller.command.user.SignUp;
import by.epam.swift.controller.command.user.UpPosition;
import by.epam.swift.controller.command.user.AddBalance;
import by.epam.swift.controller.command.user.SetBlockUser;
import by.epam.swift.controller.command.wrong.Redirect;
import by.epam.swift.controller.command.wrong.WrongRequest;
import by.epam.swift.controller.configuration.CommandName;

/**The class provides a command to execute
 * @author Archangel
 */
public final class CommandProvider {
	private static final Logger LOGGER = Logger.getLogger(CommandProvider.class);
	private final static CommandProvider instance = new CommandProvider();
	private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
		
	/** Initializing keys and commands */
	private CommandProvider(){
//INIT SOURCE
		repository.put(CommandName.INITIALIZATION_SOURCE, new InitializationSource());
		repository.put(CommandName.DESTROY_SOURCE, new DestroySource());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.LOCALIZATION, new Localization());
//NEWS
		repository.put(CommandName.ADD_NEWS, new AddNews());
		repository.put(CommandName.GET_SINGLE_NEWS, new GetSingleNews());
		repository.put(CommandName.UPLOAD_NEWS_DATA_TO_EDIT, new UploadNewsDataToEdit());
		repository.put(CommandName.EDIT_NEWS, new EditNews());
		repository.put(CommandName.REMOVE_NEWS, new RemoveNews());	
		repository.put(CommandName.GET_NEWS_LIST, new GetNewsListUser());
		repository.put(CommandName.GET_NEWS_LIST_ADMIN, new GetNewsListAdmin());
//TARIFF		
		repository.put(CommandName.ADD_TARIFF, new AddTariff());
		repository.put(CommandName.GET_SINGLE_TARIFF, new GetSingleTariff());
		repository.put(CommandName.GET_TARIFF_LIST, new GetTariffListUser());
		repository.put(CommandName.GET_TARIFF_LIST_ADMIN, new GetTariffListAdmin());	
		repository.put(CommandName.UPLOAD_DATA_TO_EDIT_TARIFF, new UploadDataToEditTariff());
		repository.put(CommandName.UPLOAD_DATA_TO_ADD_TARIFF, new UploadDataToAddTariff());
		repository.put(CommandName.EDIT_TARIFF, new EditTariff());
		repository.put(CommandName.REMOVE_TARIFF, new RemoveTariff());
		repository.put(CommandName.SEARCH_TARIFF, new SearchTariff());
		repository.put(CommandName.ADD_TARIFF_TYPE, new AddTariffType());
//AGREEMENT
		repository.put(CommandName.CREATE_AGREEMENT, new CreateAgreement());
		repository.put(CommandName.GET_AGREEMENT_LIST, new GetAgreementList());
		repository.put(CommandName.REMOVE_AGREEMENT, new RemoveAgreement());
		repository.put(CommandName.GET_SINGLE_AGREEMENT, new GetSingleAgreement());
		repository.put(CommandName.ACCEPT_AGREEMENT, new AcceptAgreement());
//USER
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_UP, new SignUp());
		repository.put(CommandName.LOGOUT, new Logout());
		repository.put(CommandName.EDIT_PROFILE, new EditProfile());
		repository.put(CommandName.BLOCK_USER, new SetBlockUser());
		repository.put(CommandName.GET_BALANCE, new GetBalance());
		repository.put(CommandName.ADD_BALANCE, new AddBalance());
		repository.put(CommandName.GET_USER_LIST, new GetUserList());
		repository.put(CommandName.UP_POSITION, new UpPosition());
//REQUEST
		repository.put(CommandName.REMOVE_REQUEST_ON_SERVICE, new RemoveRequestOnService());
		repository.put(CommandName.MAKE_REQUEST_ON_SERVICE, new MakeRequestOnService());
		repository.put(CommandName.ACCEPT_REQUEST_ON_SERVICE, new AcceptRequestOnService());
		repository.put(CommandName.GET_SINGLE_REQUEST_ON_SERVICE, new GetSingleRequestOnService());
		repository.put(CommandName.UPLOAD_DATA_TO_REQUEST_ON_SERVICE, new UploadDataToRequestOnService());
		repository.put(CommandName.GET_REQUEST_ON_SERVICE_LIST_USER, new GetRequestOnServiceListUser());
		repository.put(CommandName.GET_REQUEST_ON_SERVICE_LIST_ADMIN, new GetRequestOnServiceListAdmin());
		repository.put(CommandName.REDIRECT, new Redirect());
	}
	
	/**Command representation by key
	 * @param name command
	 * @return Command
	 */
	public Command getCommand(String name){
		CommandName commandName;
		Command command;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch (IllegalArgumentException e) {
			LOGGER.error(e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
	
		return command;
	}

	public static CommandProvider getInstance() {
		return instance;
	}
	
}
