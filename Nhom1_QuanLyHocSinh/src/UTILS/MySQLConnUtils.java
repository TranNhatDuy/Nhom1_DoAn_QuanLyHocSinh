package UTILS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMYSQLConnection() throws SQLException,
		ClassNotFoundException {
		String hostname = "localhost";
		String dbname = "test";
		String username = "root";
		String password = "";
		return getMySQLConnection(hostname, dbname, username, password);
		
	}
	public static Connection getMySQLConnection(String hostname, String dbname, String username, String password) throws SQLException,
	ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
		Connection conn = DriverManager.getConnection(connectionURL ,username, password);
		return conn;
		
	}
	
}
