package by.epam.swift.service.factory;

import by.epam.swift.service.AgreementService;
import by.epam.swift.service.InitializationSourceService;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.TariffService;
import by.epam.swift.service.UserService;
import by.epam.swift.service.impl.AgreementServiceImpl;
import by.epam.swift.service.impl.InitializationServiceImpl;
import by.epam.swift.service.impl.NewsServiceImpl;
import by.epam.swift.service.impl.RequestServiceImpl;
import by.epam.swift.service.impl.TariffServiceImpl;
import by.epam.swift.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static ServiceFactory instance = null;
	private final InitializationSourceService initializationSourceService = new InitializationServiceImpl();
	private final UserService userService = new UserServiceImpl();
	private final NewsService newsService = new NewsServiceImpl();
	private final TariffService tariffService = new TariffServiceImpl();
	private final RequestService requestService = new RequestServiceImpl();
	private final AgreementService agreementService = new AgreementServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public InitializationSourceService getInitializationSourceService() {
		return initializationSourceService;
	}

	public TariffService getTariffService() {
		return tariffService;
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public AgreementService getAgreementService() {
		return agreementService;
	}
	
}
