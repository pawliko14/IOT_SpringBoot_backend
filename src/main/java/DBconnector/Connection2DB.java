package DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connection2DB {
	private static Connection conn;
	public static Connection dbConnector()
	{
		try {	
//			Class.forName("org.mariadb.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mariadb://192.168.90.123/fatdb","listy","listy1234");


			String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
			conn = DriverManager.getConnection(url);

			return conn;
		}catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}
