package com.fat.sqlEnquiry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.fat.DBconnector.Connection2DB;
import com.fat.sqlObjects.*;


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
		conn = DriverManager.getConnection(Connection2DB.getURL());

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

	public List<object_historical> getHistoricalValue_basedOnRowLimit(int records, String table_name, String variable_name) throws  SQLException {



		Connection conn = null;
		conn = DriverManager.getConnection(Connection2DB.getURL());

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
	public List<object_historical> getHistoricalVal_basedOnWord(String timeperoid, String table_name, String variable_name) throws SQLException {

		List<object_historical>  sample_historical = new ArrayList<>() ;


		int current_date_minus = 0;


		Connection conn = null;
		conn = DriverManager.getConnection(Connection2DB.getURL());
		String sql = null;
		PreparedStatement stmnt = null;
		ResultSet rs = null;
		switch(timeperoid)
		{
			case("week"):
				 current_date_minus = timeperoid.equals("week") ?   7 :  0;

				 sql = "   select  id,variable ,value ,last_date ,last_time  from "+table_name+" ph \n" +
						"\t   where last_date  >= current_date -?\n" +
						"\t   and last_date  <= current_date \n" +
						"\t   and variable = ?";

				 stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,current_date_minus);
				stmnt.setString(2,variable_name);

				break;
			case("yesterday"):
				 current_date_minus = timeperoid.equals("yesterday") ?   1 :  0;

				sql = "   select  id,variable ,value ,last_date ,last_time  from "+table_name+" ph \n" +
						"\t   where last_date  >= current_date -?\n" +
						"\t   and last_date  <= current_date -? \n" +
						"\t   and variable = ?";

				stmnt = conn.prepareStatement(sql);

				stmnt.setInt(1,current_date_minus);
				stmnt.setInt(2,current_date_minus);
				stmnt.setString(3,variable_name);

				 break;
			case("today"):
				sql = "   select  id,variable ,value ,last_date ,last_time  from "+table_name+" ph \n" +
						"\t   where last_date  = current_date \n" +
						"\t   and last_date  = current_date  \n" +
						"\t   and variable = ?";

				stmnt = conn.prepareStatement(sql);
				stmnt.setString(1,variable_name);

				break;
			case("month") :
				current_date_minus = timeperoid.equals("month") ?   30 :  0;

				sql = "   select  id,variable ,value ,last_date ,last_time  from "+table_name+" ph \n" +
						"\t   where last_date  >= current_date -? \n" +
						"\t   and last_date  <= current_date  \n" +
						"\t   and variable = ?";

				stmnt = conn.prepareStatement(sql);

				stmnt.setInt(1,current_date_minus);
				stmnt.setString(2,variable_name);

				break;
			case("3month") :
				current_date_minus = timeperoid.equals("month") ?   90 :  0;

				sql = "   select  id,variable ,value ,last_date ,last_time  from "+table_name+" ph \n" +
						"\t   where last_date  >= current_date -? \n" +
						"\t   and last_date  <= current_date  \n" +
						"\t   and variable = ?";

				stmnt = conn.prepareStatement(sql);

				stmnt.setInt(1,current_date_minus);
				stmnt.setString(2,variable_name);

				break;
			case("alldata") :
				// here special conditions for collecting all data

				sql = "\t   select  id,variable ,value ,last_date ,last_time  from plcvariables_historical pph \n" +
						"\t   where variable = ?";

				stmnt = conn.prepareStatement(sql);

				break;

			default:
				// heres some default condifition just in case
				break;
		}
		sample_historical.clear();
		 rs = stmnt.executeQuery();

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


	public List<object_historical> getHistoricalValues_based_on_ID_Module(int modulo_record,String table_name, String variable_name,String timeperoid) throws SQLException {


		int current_date_minus = 0;


		Connection conn = null;
		conn = DriverManager.getConnection(Connection2DB.getURL());
		String sql = null;
		PreparedStatement stmnt = null;
		ResultSet rs = null;
		switch(timeperoid)
		{
			case("week"):
				current_date_minus = timeperoid.equals("week") ?   7 :  0;

				 sql = " select id,variable ,value ,last_date ,last_time from "+table_name+"  phd \n" +
						"where id% ? = 0 \n" +
						"and variable  = ?\n" +
						"and last_date  >= current_date - ?\n" +
						"and last_date  <= current_date\n" +
						"order by id desc ";

				stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,modulo_record);
				stmnt.setString(2,variable_name);
				stmnt.setInt(3,current_date_minus);

				break;
			case("yesterday"):
				current_date_minus = timeperoid.equals("yesterday") ?   1 :  0;

				sql = " select id,variable ,value ,last_date ,last_time from "+table_name+"  phd \n" +
						"where id% ? = 0 \n" +
						"and variable  = ?\n" +
						"and last_date  >= current_date - ?\n" +
						"and last_date  <= current_date - ? \n" +
						"order by id desc ";

				stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,modulo_record);
				stmnt.setString(2,variable_name);
				stmnt.setInt(3,current_date_minus);
				stmnt.setInt(4,current_date_minus);

				break;
			case("today"):

				sql = " select id,variable ,value ,last_date ,last_time from "+table_name+"  phd \n" +
						"where id% ? = 0 \n" +
						"and variable  = ?\n" +
						"and last_date  = current_date \n" +
						"and last_date  = current_date\n" +
						"order by id desc ";

				stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,modulo_record);
				stmnt.setString(2,variable_name);

				break;
			case("month") :
				current_date_minus = timeperoid.equals("month") ?   30 :  0;

				sql = " select id,variable ,value ,last_date ,last_time from "+table_name+"  phd \n" +
						"where id% ? = 0 \n" +
						"and variable  = ?\n" +
						"and last_date  >= current_date - ?\n" +
						"and last_date  <= current_date\n" +
						"order by id desc ";

				stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,modulo_record);
				stmnt.setString(2,variable_name);
				stmnt.setInt(3,current_date_minus);

				break;
			case("3month") :
				current_date_minus = timeperoid.equals("month") ?   90 :  0;

				sql = " select id,variable ,value ,last_date ,last_time from "+table_name+"  phd \n" +
						"where id% ? = 0 \n" +
						"and variable  = ?\n" +
						"and last_date  >= current_date - ?\n" +
						"and last_date  <= current_date\n" +
						"order by id desc ";

				stmnt = conn.prepareStatement(sql);
				stmnt.setInt(1,modulo_record);
				stmnt.setString(2,variable_name);
				stmnt.setInt(3,current_date_minus);

				break;
			case("alldata") :
				// here special conditions for collecting all data

				sql = "\t   select  id,variable ,value ,last_date ,last_time  from plcvariables_historical pph \n" +
						"\t   where variable = ?";

				stmnt = conn.prepareStatement(sql);

				break;

			default:
				// heres some default condifition just in case
				break;
		}


		rs = stmnt.executeQuery();

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

	public object_variables get_SingleVariable_from_Specific_table(String ID, String table_name) throws SQLException {
		object_variables obj = new object_variables();

		Connection conn = null;
		conn = DriverManager.getConnection(Connection2DB.getURL());


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


	public List<object_variables> get_PLC_variables(String tableName) throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(Connection2DB.getURL());

		object_variablesList.clear();

		// CAREFUL -> CAN CUASE SQL INJECTION
		String sql = "select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from "+tableName+" pd";

			// careful its not working
	//	String sql = String.format("select id,last_changed_time ,status ,var,last_changed_date,var_meaning ,value ,var_path from $1%s pd",  tableName);

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
		conn = DriverManager.getConnection(Connection2DB.getURL());



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
		conn = DriverManager.getConnection(Connection2DB.getURL());

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
		conn = DriverManager.getConnection(Connection2DB.getURL());



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
