package it.corsojava.testmav.utils.servlet;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import it.corsojava.testmav.utils.ConfigBin;
import it.corsojava.testmav.utils.dao.ServerManager;

public class ServerLoaderServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ConfigBin cb = new ConfigBin();

		String driver = getInitParameter("DATABASE_DRIVER");
		cb.setDriver(driver);
		String url = getInitParameter("DATABASE_URL");
		cb.setUrl(url);
		String username = getInitParameter("DATABASE_USERNAME");
		cb.setUsername(username);
		String password = getInitParameter("DATABASE_PASSWORD");
		cb.setPassword(password);

		// RECUPERO PARAMETRI PER DATASOURCE
		String database = getInitParameter("CONNECTION");
		cb.setDatabase(database);
		String dat = getInitParameter("DATABASE_ENV");
		cb.setDat(dat);
		String jdbc = getInitParameter("DATABASE_JDBC");
		cb.setJdbc(jdbc);

		try {
			ServerManager.getInstance().initDatabase(cb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
