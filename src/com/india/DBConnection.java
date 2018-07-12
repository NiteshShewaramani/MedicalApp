package com.india;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DBConnection {

    private static Connection con;
    private static Statement st;

    //Static Block - To initialize Static Variables
    static {
        try {
            //Step I: Read settings from Property File
            Properties p = new Properties();
            InputStream in = DBConnection.class.getResourceAsStream("Settings.properties");
            if (in == null) {
                throw new Error("Inputstream Not Found");
            }
            p.load(in);  //Load settings from property file into p
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            String url = p.getProperty("url");
            String drivername = p.getProperty("drivername");
            //Step I DriverRegisteration  
            Class.forName(drivername).newInstance();
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            con.setAutoCommit(false);  //OCJP: For Transaction Application
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Connect" + e.toString());
        }
    }

    public static void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Close" + e.toString());
        }
    }

    public static ResultSet executeQuery(String sql) throws SQLException {                            //For Select
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
//for insert/update/delete

    public static int executeUpdate(String sql) throws SQLException {
        int result = st.executeUpdate(sql);
        return result;
    }
   public static void commit() throws SQLException
   {
       if(con!=null)  con.commit();
   }
   public static void prepareCombo(ResultSet rs, ArrayList<String>names , ArrayList<Integer>ids) throws SQLException
   {
       while(rs.next())
       {
      ids.add(rs.getInt(1));  //Column Position ID
      names.add(rs.getString(2));
       }
   }
    public static DefaultTableModel prepareTable(ResultSet rs) throws SQLException {
        DefaultTableModel d;
        d = new DefaultTableModel();    //Local Variable
        //1. create an array of column names       
        ResultSetMetaData metadata = rs.getMetaData();
        int colCount = metadata.getColumnCount();
        String[] colNames = new String[colCount];
        for (int i = 1; i <= colCount; i++) {
            colNames[i - 1] = metadata.getColumnName(i);
        }
        d.setColumnIdentifiers(colNames);
        //now populate the data       
        while (rs.next()) {
            String[] rowData = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                rowData[i] = rs.getString(i + 1);
            }
            d.addRow(rowData);
        }
        return d;
    }
}
