package com.tmp.m0108;

//package sql.demo;

import java.sql.*;

public class StockExchangeDB {
    // 1. Вариант для "H2 Database Engine" (http://www.h2database.com/)
    // public static final String DB_URL = "jdbc:h2:/c:/JavaPrj/SQLDemo/db/stockExchange";
    // public static final String DB_Driver = "org.h2.Driver";

    // 2. Вариант для Oracle RDBMS
    // 2.1. thin, польователь и пароль определены в строке соединения
    //  public static final String DB_URL = "jdbc:oracle:thin:test/t@localhost:1521:orcl";
    //  Connection connection = DriverManager.getConnection( DB_URL);//соединениесБД

    // 2.2. thin, польователь и пароль определены не в строке соединения - отдельно.
    public static final String DB_URL = "jdbc:oracle:thin:/@localhost:1521:orcl";
    //  Connection connection = DriverManager.getConnection( DB_URL, user, passw);//соединениесБД

    // 2.3. oci
    // public static final String DB_URL = "jdbc:oracle:oci:/@localhost:1521:orcl";
    // Видимо версия клиента и сервера не совпадает. Возникает исключение:
    // Exception in thread "main" java.lang.UnsatisfiedLinkError: no ocijdbc21 in java.library.path:
    // C:\.jdks\openjdk-15\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;
    // C:\Program Files (x86)\Common Files\Oracle\Java\javapath;D:\Soft\System\Oracle.WINDOWS.X64_193000_db_home\bin;
    // C:\ProgramData\Anaconda2;C:\ProgramData\Anaconda2\Library\mingw-w64\bin;C:\ProgramData\Anaconda2\Library\\usr\bin;
    // C:\ProgramData\Anaconda2\Library\bin;C:\ProgramData\Anaconda2\Scripts;
    // C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;
    // C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\WINDOWS\system32;C:\WINDOWS;
    // C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;
    // C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;
    // C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;
    // C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;
    // C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\dotnet\;
    // C:\Program Files (x86)\dotnet\;C:\Program Files (x86)\Common Files\Acronis\VirtualFile\;
    // C:\Program Files (x86)\Common Files\Acronis\VirtualFile64\;C:\Program Files (x86)\Common Files\Acronis\SnapAPI\;
    // C:\Program Files\PuTTY\;C:\Program Files\maven\bin;C:\Program Files\Git\cmd;
    // C:\Users\Максим\AppData\Local\Microsoft\WindowsApps;
    // C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.1\bin;;;.

    public static final String DB_Driver = "oracle.jdbc.OracleDriver";

    public static final String user = "test";
    public static final String passw = "t";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main( String[ ] args) {
        String query = "select sysdate as current_day from dual";//"select * from dual";

        try {
            Class.forName( DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
            con = DriverManager.getConnection( DB_URL, user, passw);//соединениесБД
            System.out.println( "Соединение с СУБД выполнено.");

            // getting Statement object to execute query
            stmt = con.createStatement( );
            // executing SELECT query
            rs = stmt.executeQuery( query);
            System.out.println( rs.getMetaData().getColumnName( 1));
            while ( rs.next( )) {
                System.out.println( rs.getString( 1));
            }

            /*
            rs.moveToInsertRow( );
            //First param is db column name,second param is variable name
            rs.updateString( "USERNAME", username);
            rs.updateString( "FNAME", fname);
            rs.updateString( "MNAME", mname);
            rs.updateString( "LNAME", lname);
            rs.updateString( "GENDER", gender);
            rs.updateString( "DEPARTMENT", dept);
            rs.insertRow( );
            rs.close( );
            smt.close( );
            */
        } catch ( ClassNotFoundException e) {
            e.printStackTrace( ); // обработка ошибки  Class.forName
            System.out.println( "JDBC драйвер для СУБД не найден!");
        }
        catch ( SQLException e) {
            e.printStackTrace( ); // обработка ошибок  DriverManager.getConnection
            System.out.println( "Ошибка SQL!");
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close( ); // отключение от БД
                System.out.println( "Отключение от СУБД выполнено.");
            } catch( SQLException se) { /*can't do anything */ }
            try {
                stmt.close( );
            } catch( SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch( SQLException se) { /*can't do anything */ }
        }
    }
}
