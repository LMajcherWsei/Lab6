package pl.lublin.wsei.java.cwiczenia.lab6.test;

import pl.lublin.wsei.java.cwiczenia.lab6.MyDB;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", 3306, "mydb");
        db.setUser("root");
        db.setPassword("Wsei20@@");
        Connection conn = db.getConnection();
        if (conn != null)
            System.out.println("Połączenie z bazą danych nawiązane");
        db.closeConnection();
        System.out.println("Połączenie z bazą zakończone");
    }
}
