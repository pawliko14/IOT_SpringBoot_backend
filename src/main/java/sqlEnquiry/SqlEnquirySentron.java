package sqlEnquiry;

import DBconnector.Connection2DB;
import SentronEntities.Modbus_data;
import SentronEntities.Modbus_historical;
import sqlObjects.object_historical;
import sqlObjects.object_variables;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlEnquirySentron {

    List<Modbus_data> modbus_data;


    public SqlEnquirySentron() {
        modbus_data = new ArrayList<>();
    }

    public Modbus_data getModbus_dataByIndex(int index) throws SQLException {

        Connection conn = null;
        conn = DriverManager.getConnection(Connection2DB.getURL());

        Modbus_data obj = null;

        String sql = " select id,last_changed_time ,var ,last_changed_date , value  from modbus_data md  where id = ? order by id asc ";

        try
        {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            stmnt.setInt(1,index);
            ResultSet rs = stmnt.executeQuery();

            if (rs.next() == false) {
                System.out.println("There is no record in database");
            } else {
                do {
                     obj = new Modbus_data(
                            rs.getInt("id"),
                            rs.getString("last_changed_time"),
                            rs.getString("var"),
                            rs.getString("last_changed_date"),
                            rs.getString("value")
                    );

                } while (rs.next());
            }
            stmnt.close();
            rs.close();


        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return obj;
    }
    public List<Modbus_data> getModbus_data() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(Connection2DB.getURL());

        modbus_data.clear();

        String sql = " select id,last_changed_time ,var ,last_changed_date , value  from modbus_data md  order by id asc ";

        try
        {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            ResultSet rs = stmnt.executeQuery();

            while(rs.next())
            {
                Modbus_data obj = new Modbus_data(
                        rs.getInt("id"),
                        rs.getString("last_changed_time"),
                        rs.getString("var"),
                        rs.getString("last_changed_date"),
                        rs.getString("value")
                );


                modbus_data.add(obj);
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


        return modbus_data;
    }

    public List<Modbus_historical> getHistoricalBasedOnWord(String timeperoid, String variable_name) throws SQLException {


        List<Modbus_historical>  sample_historical = new ArrayList<>() ;


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

                sql = "    select last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where  TO_DATE(last_date, 'YYYY-MM-DD')  >= current_date - ?\n" +
                        "    and    TO_DATE(last_date, 'YYYY-MM-DD') = current_date\n" +
                        "    and variable  = ?\n" +
                        "    order by id desc ";

                stmnt = conn.prepareStatement(sql);
                stmnt.setInt(1,current_date_minus);
                stmnt.setString(2,variable_name);

                break;
            case("yesterday"):
                current_date_minus = timeperoid.equals("yesterday") ?   1 :  0;

                sql = "    select last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where  TO_DATE(last_date, 'YYYY-MM-DD')  >= current_date - ?\n" +
                        "    and TO_DATE(last_date, 'YYYY-MM-DD')  <= current_date -?\n" +
                        "    and variable  = ?\n" +
                        "    order by id desc  ";

                stmnt = conn.prepareStatement(sql);

                stmnt.setInt(1,current_date_minus);
                stmnt.setInt(2,current_date_minus);
                stmnt.setString(3,variable_name);

                break;
            case("today"):
                sql = "     select last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where  TO_DATE(last_date, 'YYYY-MM-DD')  = current_date \n" +
                        "    and TO_DATE(last_date, 'YYYY-MM-DD')  = current_date \n" +
                        "    and variable  = ?\n" +
                        "    order by id desc";

                stmnt = conn.prepareStatement(sql);
                stmnt.setString(1,variable_name);

                break;
            case("month") :
                current_date_minus = timeperoid.equals("month") ?   30 :  0;

                sql = "     select last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where  TO_DATE(last_date, 'YYYY-MM-DD')  >= current_date - ?\n" +
                        "    and TO_DATE(last_date, 'YYYY-MM-DD')  <= current_date\n" +
                        "    and variable  = ?\n" +
                        "    order by id desc  ";

                stmnt = conn.prepareStatement(sql);

                stmnt.setInt(1,current_date_minus);
                stmnt.setString(2,variable_name);

                break;
            case("3month") :
                current_date_minus = timeperoid.equals("month") ?   90 :  0;

                sql = "     select id,last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where  TO_DATE(last_date, 'YYYY-MM-DD')  >= current_date - ?\n" +
                        "    and TO_DATE(last_date, 'YYYY-MM-DD')  <= current_date\n" +
                        "    and variable  = ?\n" +
                        "    order by id desc ";

                stmnt = conn.prepareStatement(sql);

                stmnt.setInt(1,current_date_minus);
                stmnt.setString(2,variable_name);

                break;
            case("alldata") :
                // here special conditions for collecting all data

                sql = "    select last_time ,variable ,last_date , value  from modbus_historical ph \n" +
                        "    where variable  = ?\n" +
                        "    order by id desc ";

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



            Modbus_historical obj = new Modbus_historical(variable,value,last_date,last_time);


            sample_historical.add(obj);
        }

        stmnt.close();
        rs.close();
        conn.close();

        return sample_historical;
    }

    public List<Modbus_historical> getHistoricalValue_basedOnRowLimit(int records, String variableName) throws SQLException {

        List<Modbus_historical> object_list = new ArrayList<>();

        Connection conn = null;
        conn = DriverManager.getConnection(Connection2DB.getURL());


        String sql = " select variable ,value ,last_date ,last_time from modbus_historical ph \n" +
                "        where variable  = ?\n" +
                "        order by last_date desc , last_time  desc limit ?";

        PreparedStatement stmnt = conn.prepareStatement(sql);
        stmnt.setString(1,variableName);
        stmnt.setInt(2,records);

        ResultSet rs = stmnt.executeQuery();


        while(rs.next())
        {
            String variable = rs.getString("variable");
            String value = rs.getString("value");
            String last_date = rs.getString("last_date");
            String last_time = rs.getString("last_time");



            Modbus_historical obj = new Modbus_historical(variable,value,last_date,last_time);


            object_list.add(obj);
        }

        stmnt.close();
        rs.close();
        conn.close();


        return object_list;

    }


}
