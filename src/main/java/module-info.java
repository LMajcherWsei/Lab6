module pl.lublin.wsei.java.cwiczenia.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pl.lublin.wsei.java.cwiczenia.lab6 to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.lab6;
}