module com.dam.chatsocket_java {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.dam.chatsocket_java to javafx.fxml;
    exports com.dam.chatsocket_java;
}