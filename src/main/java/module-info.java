module com.example.a5min {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.a5min to javafx.fxml;
    exports com.example.a5min;
}