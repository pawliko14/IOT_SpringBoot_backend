package DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connection2DB {
	private static Connection conn;
	public static Connection dbConnector()
	{
		try {
			String url = "jdbc:postgresql://192.168.90.199/machinedata?user=iot&password=iotfat";
			conn = DriverManager.getConnection(url);

			return conn;
		}catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public static String getURL() {
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=iot&password=iotfat";

		return url;
	}
}
