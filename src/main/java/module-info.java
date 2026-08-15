module com.example.github_dummy_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.github_dummy_final to javafx.fxml;
    exports com.example.github_dummy_final;
}