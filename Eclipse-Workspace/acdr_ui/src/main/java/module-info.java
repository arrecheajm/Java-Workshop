module org.heard.acdr_ui {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.heard.acdr_ui to javafx.fxml;
    exports org.heard.acdr_ui;
}
