package com.example.github_dummy_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class processionFinalController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> genderCB;
    @javafx.fxml.FXML
    private DatePicker dojDatePicker;
    @javafx.fxml.FXML
    private TextField phnNUmTF;
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    @javafx.fxml.FXML
    public void initialize() {
        genderCB.getItems().addAll("Male","Female","Others");
    }
    public  void showAlert(String s){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void addOA(ActionEvent actionEvent) {

        if(nameTF.getText() == null || nameTF.getText().isEmpty()){
            showAlert("Name textField should be filled");
            return;
        }
        String name ;
        try{
            name = nameTF.getText();
        }catch (Exception e){
            showAlert("Name textField should be a String");
            return;
        }

        if(phnNUmTF.getText() == null || phnNUmTF.getText().isEmpty()){
            showAlert("Phone Number  textField should be filled");
            return;
        }
        int phoneNUmber;
        try{
            phoneNUmber = Integer.parseInt(phnNUmTF.getText());
        }catch (NumberFormatException e ){
            showAlert("Phone Number textField should be an integer");
            return;
        }
        if(genderCB.getValue() == null ){
            showAlert("Gender combo BOx should be selected");
            return;
        }
        if(dojDatePicker.getValue() == null){
            showAlert("Date Picker  should be selected");
            return;
        }
        if(dojDatePicker.getValue().isBefore(LocalDate.now())){
            showAlert(" select the date should not be past date or before the present date");
            return;
        }


        Employee employee = new Employee(
                name,
                genderCB.getValue(),
                Integer.parseInt(phnNUmTF.getText()),
                dojDatePicker.getValue()
        );

        File file = new File("employee.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }oos.writeObject(employee);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

    }

    @javafx.fxml.FXML
    public void nextPageOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finalCreation.fxml"));
        Node node = fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}