package com.tmp.m0106;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static Connection conn;

    // CDB:
    // private static String url = "jdbc:oracle:thin:/@localhost:1521:orcl";

    // PDB:
    // Driver name: oracle.jdbc.driver.OracleDriver
    // URL: jdbc:oracle:thin:@hostname:portNumber/databaseName
    private static String url = "jdbc:oracle:thin:/@localhost:1521/orclpdb";

    private static String user = "tm";
    private static String pass = "tm";

    public static Connection connect( ) throws SQLException {
        try {
            // Class.forName( "com.mysql.jdbc.Driver").newInstance();
            Class.forName( "oracle.jdbc.OracleDriver").newInstance();
            // Class.forName( "oracle.jdbc.OracleDriver");
        } catch( ClassNotFoundException cnfe){
            System.err.println( "Error: " + cnfe.getMessage( ));
        } catch( InstantiationException ie){
            System.err.println( "Error: " + ie.getMessage( ));
        } catch( IllegalAccessException iae){
            System.err.println( "Error: " + iae.getMessage( ));
        }

        conn = DriverManager.getConnection( url, user, pass);
        return conn;
    }

    public static Connection getConnection( ) throws SQLException, ClassNotFoundException {
        if ( conn != null && !conn.isClosed( ))
            return conn;
        connect( );
        return conn;
    }
}

