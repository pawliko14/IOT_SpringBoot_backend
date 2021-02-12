package sqlEnquiry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sqlObjects.*;


public class SqlEnquiry {

	static Connection connection;
	List<object_variables> object_variablesList;
	List<object_variables> tools_data;
	// for testing purpose
	List<object_historical> object_historical_MB5;


	public SqlEnquiry()
	{
		object_variablesList = new ArrayList<>();
		object_historical_MB5 = new ArrayList<>();
		tools_data = new ArrayList<>();
	}


	/*
	*** Historical, testing purpose
	 */
	public List<object_historical> getHistorical_MB5() throws SQLException {

		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);

		object_historical_MB5.clear();

		String sql = " select variable ,value ,last_date ,last_time from plcvariables_historical ph \n" +
				"        where variable  = 'MB5'\n" +
				"        order by last_date desc , last_time  desc limit 20";

		PreparedStatement stmnt = conn.prepareStatement(sql);
		ResultSet rs = stmnt.executeQuery();


		while(rs.next())
		{
			String variable = rs.getString("variable");
			String value = rs.getString("value");
			String last_date = rs.getString("last_date");
			String last_time = rs.getString("last_time");



			object_historical obj = new object_historical(variable,value,last_date,last_time);


			object_historical_MB5.add(obj);
		}

		stmnt.close();
		rs.close();
		conn.close();


		return object_historical_MB5;
	}


	/*
	*** get historical variable from specyfic table
	 */
	public List<object_historical> getHostoricalVar_last_10(int records, String table_name,String variable_name) throws  SQLException {



		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);

		object_historical_MB5.clear();

		String sql = " select variable ,value ,last_date ,last_time from "+table_name+" ph \n" +
				"        where variable  = ?\n" +
				"        order by last_date desc , last_time  desc limit ?";

		PreparedStatement stmnt = conn.prepareStatement(sql);
		stmnt.setString(1,variable_name);
		stmnt.setInt(2,records);

		ResultSet rs = stmnt.executeQuery();


		while(rs.next())
		{
			String variable = rs.getString("variable");
			String value = rs.getString("value");
			String last_date = rs.getString("last_date");
			String last_time = rs.getString("last_time");



			object_historical obj = new object_historical(variable,value,last_date,last_time);


			object_historical_MB5.add(obj);
		}

		stmnt.close();
		rs.close();
		conn.close();


		return object_historical_MB5;
	}
	public List<object_historical> getHostoricalVar_last_7_days(String timeperoid, String table_name, String variable_name) throws SQLException {

		List<object_historical>  sample_historical = new ArrayList<>() ;


//		if(!timeperoid.equals("week")){
//			return null;
//		}

		int current_date_minus = timeperoid.equals("week") ?   7 :  0;

		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);

		sample_historical.clear();

		String sql = "   select * from "+table_name+" ph \n" +
				"\t   where last_date  >= current_date -?\n" +
				"\t   and last_date  <= current_date \n" +
				"\t   and variable = ?";

		PreparedStatement stmnt = conn.prepareStatement(sql);
		stmnt.setInt(1,current_date_minus);
		stmnt.setString(2,variable_name);

		ResultSet rs = stmnt.executeQuery();


		while(rs.next())
		{
			String variable = rs.getString("variable");
			String value = rs.getString("value");
			String last_date = rs.getString("last_date");
			String last_time = rs.getString("last_time");



			object_historical obj = new object_historical(variable,value,last_date,last_time);


			sample_historical.add(obj);
		}

		stmnt.close();
		rs.close();
		conn.close();


		return sample_historical;
	}


	public object_variables get_SingleVariable_from_Specific_table(String ID, String table_name) throws SQLException {
		object_variables obj = new object_variables();

		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);


			// CAREFULL!!! VURNEABLE ON SQL INJECTION, table_name SHOULD BE STORED IN HASHMAP, THEN RETRIVED
		String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from "+table_name +" pd where id = ?";

		try
		{
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, Integer.parseInt(ID));
			ResultSet rs = stmnt.executeQuery();

			while(rs.next())
			{
				String id = rs.getString("id");
				String last_changed_time = rs.getString("last_changed_time");
				String status = rs.getString("status");
				String var = rs.getString("var");
				String last_changed_date = rs.getString("last_changed_date");
				String var_meaning = rs.getString("var_meaning");
				String value = rs.getString("value");
				String var_path = rs.getString("var_path");


				obj.setID(id);
				obj.setLast_changed_time(last_changed_time);
				obj.setStatus(status);
				obj.setVar(var);
				obj.setLast_changed_date(last_changed_date);
				obj.setVar_meaning(var_meaning);
				obj.setValue(value);
				obj.setVar_path(var_path);


			}
			stmnt.close();
			rs.close();

		}
		catch(Exception e){ e.printStackTrace(); }


		try { conn.close(); }
		catch (SQLException e) { e.printStackTrace(); }


		return obj;
	}


	public List<object_variables> get_PLC_variables() throws SQLException {
		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);

		object_variablesList.clear();

		String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from plcvariables_data pd";


		try
		{
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();

			while(rs.next())
			{
				String id = rs.getString("id");
				String last_changed_time = rs.getString("last_changed_time");
				String status = rs.getString("status");
				String var = rs.getString("var");
				String last_changed_date = rs.getString("last_changed_date");
				String var_meaning = rs.getString("var_meaning");
				String value = rs.getString("value");
				String var_path = rs.getString("var_path");


				object_variables obj = new object_variables(id,last_changed_time,status,var,last_changed_date,var_meaning,value,var_path);


				object_variablesList.add(obj);
			}
			stmnt.close();
			rs.close();


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return object_variablesList;
	}


	public List<object_variables> get_programData() throws SQLException {

		List<object_variables> List_programData = new ArrayList<>();
		List_programData.clear();

		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);



		String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from program_data pd";

		try
		{
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();

			while(rs.next())
			{
				String id = rs.getString("id");
				String last_changed_time = rs.getString("last_changed_time");
				String status = rs.getString("status");
				String var = rs.getString("var");
				String last_changed_date = rs.getString("last_changed_date");
				String var_meaning = rs.getString("var_meaning");
				String value = rs.getString("value");
				String var_path = rs.getString("var_path");


				object_variables obj = new object_variables(id,last_changed_time,status,var,last_changed_date,var_meaning,value,var_path);


				List_programData.add(obj);
			}
			stmnt.close();
			rs.close();

		}
		catch(Exception e){ e.printStackTrace(); }


		try { conn.close(); }
		catch (SQLException e) { e.printStackTrace(); }


		return List_programData;

	}

	public List<object_variables> get_toolsData() throws SQLException {
		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);

		tools_data.clear();

	String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from tools_data td";

		try
		{
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();

			while(rs.next())
			{
				String id = rs.getString("id");
				String last_changed_time = rs.getString("last_changed_time");
				String status = rs.getString("status");
				String var = rs.getString("var");
				String last_changed_date = rs.getString("last_changed_date");
				String var_meaning = rs.getString("var_meaning");
				String value = rs.getString("value");
				String var_path = rs.getString("var_path");


				object_variables obj = new object_variables(id,last_changed_time,status,var,last_changed_date,var_meaning,value,var_path);


				tools_data.add(obj);
			}
			stmnt.close();
			rs.close();


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return tools_data;
	}


	public object_variables get_programData_id(String ID) throws SQLException {

		object_variables obj = new object_variables();

		Connection conn = null;
		String url = "jdbc:postgresql://192.168.90.199/machinedata?user=Konrad&password=IamTheKing";
		conn = DriverManager.getConnection(url);



		String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from program_data pd where id = ?";

		try
		{
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, Integer.parseInt(ID));
			ResultSet rs = stmnt.executeQuery();

			while(rs.next())
			{
				String id = rs.getString("id");
				String last_changed_time = rs.getString("last_changed_time");
				String status = rs.getString("status");
				String var = rs.getString("var");
				String last_changed_date = rs.getString("last_changed_date");
				String var_meaning = rs.getString("var_meaning");
				String value = rs.getString("value");
				String var_path = rs.getString("var_path");


				obj.setID(id);
				obj.setLast_changed_time(last_changed_time);
				obj.setStatus(status);
				obj.setVar(var);
				obj.setLast_changed_date(last_changed_date);
				obj.setVar_meaning(var_meaning);
				obj.setValue(value);
				obj.setVar_path(var_path);


			}
			stmnt.close();
			rs.close();

		}
		catch(Exception e){ e.printStackTrace(); }


		try { conn.close(); }
		catch (SQLException e) { e.printStackTrace(); }


		return obj;

	}


}
