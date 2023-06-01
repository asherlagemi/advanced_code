module com.example.advanced_code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.view.advanced_code to javafx.fxml;
    exports com.view.advanced_code;
}