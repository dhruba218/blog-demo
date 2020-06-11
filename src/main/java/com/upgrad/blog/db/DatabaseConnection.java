package com.upgrad.blog.db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO 6.2: Implement the DatabaseConnection class using the Singleton Pattern (Hint. Should have the 
 * private no-arg constructor).
 * TODO 6.3: The getInstance() method should create a connection object which is
 * connected with the local database and return this connection object.
 * TODO 6.4: You should handle the ClassNotFoundException and SQLException individually,
 * and not using the Exception class.
 */
public class DatabaseConnection {

    private static DatabaseConnection jdbc;
    private DatabaseConnection(){

    }
    public static DatabaseConnection getInstance() {
        if (jdbc==null)
        {
            jdbc=new DatabaseConnection();
        }
        return jdbc;
    }
    public static Connection getConnection()throws ClassNotFoundException, SQLException
    {

        Connection con=null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","cse218");
        return con;

    }


    public static void main(String[] args) throws SQLException{
        try {
        	DatabaseConnection.getConnection();
        	System.out.println("Connected");
        } catch (Exception e) {
        	System.out.println("Not Connected");
        }
    }
}
