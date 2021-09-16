package com.fat.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connection2DB {
	private static Connection conn;
	public static Connection dbConnector()
	{
		try {
			String url = "jdbc:postgresql://host.docker.internal:5432/postgres?user=iot_x&password=iotfat";
			conn = DriverManager.getConnection(url);

			return conn;
		}catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public static String getURL() {
		String url = "jdbc:postgresql://host.docker.internal:5432/postgres?user=iot&password=iotfat";

		return url;
	}
}
