import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class DBUtill {
	
	private static final String DB_USERNAME ="root";
	private static final String DB_PASSWORD ="Root@123";
	private static final String DB_URL ="jdbc:mysql://localhost:3306/dark";
	private static final String DB_DRIVER_CLASS ="com.mysql.cj.jdbc.Driver";

	private static BasicDataSource dataSource;
	
	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER_CLASS);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		
		dataSource.setMinIdle(0);
		dataSource.setMaxIdle(10);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
		
	}

}
