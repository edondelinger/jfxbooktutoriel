package com.example.bookapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController  implements Initializable {

    @FXML
    private Button BtnAdd;

    @FXML
    private Button BtnDelete;

    @FXML
    private HBox HBox4Btns;

    @FXML
    private Label LblAddText;

    @FXML
    private ListView<Book> listBoxMain;

    @FXML
    private Label TitleLbl;

    @FXML
    private VBox VBoxMain;

    @FXML
    private TextField txtAddItem;

    final ObservableList<Book> listItems = FXCollections.observableArrayList();

    // Add event handlers
    @FXML
    private void addAction(ActionEvent action){
        //listItems.add(txtAddItem.getText());
        System.out.println("Add Button Pushed");
    }


    @FXML
    private void deleteAction(ActionEvent action){
        int selectedItem = listBoxMain.getSelectionModel().getSelectedIndex();
        listItems.remove(selectedItem);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Book book1 = new Book(1L, "J01", "Java IO Tutorial");
        Book book2 = new Book(2L, "J02", "Java Enums Tutorial");
        Book book3 = new Book(2L, "C01", "C# Tutorial for Beginners");

        listItems.add(book1);
        listItems.add(book2);
        listItems.add(book3);

        listBoxMain.setItems(listItems);

        // Disable buttons to start
        BtnAdd.setDisable(true);
        BtnDelete.setDisable(true);

        // Add a ChangeListener to TextField to look for change in focus
        txtAddItem.focusedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(txtAddItem.isFocused()){
                    BtnAdd.setDisable(false);
                }
            }
        });

        // Add a ChangeListener to ListView to look for change in focus
        listBoxMain.focusedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(listBoxMain.isFocused()){
                    BtnDelete.setDisable(false);
                }
            }
        });

    }
}