package pl.lublin.wsei.java.cwiczenia.lab6;

import java.sql.*;
import java.util.Properties;

public class MyDB {

    private String user;
    private String password;
    private Connection conn = null;
    private Statement statement = null;

    String host;
    String dbName;
    Number port;

    public MyDB(String host, Number port, String dbName) {
        this.host = host;
        this.dbName = dbName;
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "Wsei20@@");
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":"  + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
            statement = conn.createStatement();
        }
        catch (SQLException e) {
            System.out.println("Błąd podłączenia do bazy: " + jdbcString);
            System.out.println("Komunikat błędu: " + e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database " + dbName);
    }

    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void closeConnection() {
        if (conn != null)
            try {
                conn.close();
            }
            catch (SQLException e) {
                System.out.println("Błąd przy zamykaniu połączenia bazodanowego" + e.getMessage());
            }
        conn = null;
    }

    public ResultSet selectData(String selectStatement) {
        if ((conn != null) && (statement != null))
            try {
                return statement.executeQuery(selectStatement);
            } catch (SQLException e) {
                System.out.println("Błąd realizacji zapytania: " + selectStatement + ", " + e.getMessage());
            }
        return null;
    }
}
