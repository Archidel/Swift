package by.epam.swift.dao.connection.manager;

import java.util.ResourceBundle;

public class DBResourceManager {
	private final static DBResourceManager instance = new DBResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("resource.database");
	
	private DBResourceManager() {}

	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key){
		return bundle.getString(key);
	}
	
}
