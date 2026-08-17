package com.example.github_dummy_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class creationFinalController {
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> phoneNUmberTV;
    @javafx.fxml.FXML
    private TextField filterNameTF;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTV;
    @javafx.fxml.FXML
    private TableView<Employee> mianTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, LocalDate> dojTV;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> genderTV;
    @javafx.fxml.FXML
    private ComboBox<String> filterGenderCB;
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    @javafx.fxml.FXML
    public void initialize() {
        mianTableView.getItems().clear();

        filterGenderCB.getItems().addAll("Male", "Female", "Other");

        nameTV.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTV.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phoneNUmberTV.setCellValueFactory(new PropertyValueFactory<>("phoneNUmber"));
        dojTV.setCellValueFactory(new PropertyValueFactory<>("doj"));
    }

    @javafx.fxml.FXML
    public void previousPageOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finalProcession.fxml"));
        Node node = fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        mianTableView.getItems().clear();
        try {
            FileInputStream fis = new FileInputStream("employee.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Employee employee = (Employee) ois.readObject();
                    if (filterNameTF.getText().equals(employee.getName())
                            && filterGenderCB.getValue().equals(employee.getGender())) {
                        mianTableView.getItems().addAll(employee);
                    }
                } catch (IOException e) {
                    break;
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}