module com.example.advanced_code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advanced_code to javafx.fxml;
    exports com.example.advanced_code;
}