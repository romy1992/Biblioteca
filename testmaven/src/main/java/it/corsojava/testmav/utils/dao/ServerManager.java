package it.corsojava.testmav.utils.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.corsojava.testmav.utils.ConfigBin;

public class ServerManager {

	private static ServerManager _instance;
	private ConfigBin cb;
	private DataSource datasource;

	public ServerManager() {

	}

	public static synchronized ServerManager getInstance() {
		if (_instance == null)
			_instance = new ServerManager();
		return _instance;
	}

	public void initDatabase(ConfigBin cb) throws ClassNotFoundException {
		this.cb = cb;
		if ("0".equals(this.cb.getDatabase()))
			Class.forName(this.cb.getDriver());

	}

	public Connection connection() throws SQLException, NamingException {
		if ("0".equals(cb.getDatabase()))
			return DriverManager.getConnection(this.cb.getUrl(), this.cb.getUsername(), this.cb.getPassword());
		else if ("1".equals(cb.getDatabase()))
			return getDatasource().getConnection();
		return null;
	}

	
	private DataSource getDatasource() throws NamingException {
		if(this.datasource==null) {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup(cb.getDat());
			this.datasource = (javax.sql.DataSource) envContext.lookup(cb.getJdbc());
		}
		return this.datasource;
	}
}
