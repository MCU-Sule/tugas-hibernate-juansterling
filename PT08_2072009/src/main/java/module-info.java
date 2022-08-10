module com.example.UTS_2072009 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;


    opens com.example.PT08_2072009 to javafx.fxml;
    exports com.example.PT08_2072009;

    opens com.example.PT08_2072009.Controller to javafx.fxml;
    exports com.example.PT08_2072009.Controller;

    opens com.example.PT08_2072009.Dao to javafx.fxml;
    exports com.example.PT08_2072009.Dao;

    opens com.example.PT08_2072009.Model;
    exports com.example.PT08_2072009.Model;

    opens com.example.PT08_2072009.Util to javafx.fxml;
    exports com.example.PT08_2072009.Util;
}