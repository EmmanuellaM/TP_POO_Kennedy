module com.tpobjetperdu {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens com.tpobjetperdu to javafx.fxml, javafx.graphics, java.sql;
    exports com.tpobjetperdu;
}
