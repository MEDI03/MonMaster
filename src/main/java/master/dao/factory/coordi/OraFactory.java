package master.dao.factory.coordi;
import  master.dao.imp.coordi.*; 
import java.sql.DriverManager;
import java.sql.*;

public class OraFactory {
	public  static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String dbUrl="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	public static final String username="mehdi";
	public static final String password="12369";

public static Connection getConnection() throws SQLException{
	try {
		Class.forName(driver);
	}catch(ClassNotFoundException ec) {ec.printStackTrace();}
	
	return DriverManager.getConnection(dbUrl,username,password);

}

public static ResponsableDaoImp getResponsableDao() {
	return new ResponsableDaoImp();
}

}