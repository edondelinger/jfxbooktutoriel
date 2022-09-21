module com.example.bookapp {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.bookapp to javafx.fxml;
    exports com.example.bookapp;
}