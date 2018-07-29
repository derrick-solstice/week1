import sun.jvm.hotspot.asm.sparc.SPARCArgument;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper
{

    //Create a singleton
    private static Connection conn = null;


    //Database Constants
    private static final String USERNAME = "week1";
    private static final String PASSWORD = "Week1@Solstic3";
    private static final String CONN_STRING = "jdbc:mysql://localhost/week1";


    // Singleton Connection Constructor
    private static Connection dbConnection()
    {
        try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        }
        catch(SQLException e){
            System.err.println(e.getNextException());
        }
        finally{
            return conn;
        }
    }


    // Public Access Method
    public static Connection getConnection()
    {
        if (conn == null) {
            conn = dbConnection();
            return conn;
        }
        return conn;
    }

    //todo: Add a method for the flush of the table

    //todo: Add a method for the batch insert to the table.

    //todo: Add a method for the query for the stocks

    //todo: Add a method to return a list of the Symbols in the table

    //todo: Add a method to return the earliest date in the table

    //todo: Add a method to return the latest date in the table


    // Close connection method called at the end of main
    public static void close() {

        try {
            conn.close();
            conn = null;
        }
        catch (SQLException e) {
            System.err.println("Error Code : " + e.getErrorCode());
            System.err.println("SQL State : " + e.getSQLState());
            System.err.println("Message : " + e.getNextException());
        }
    }
}