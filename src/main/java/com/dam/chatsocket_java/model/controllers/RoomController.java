package com.dam.chatsocket_java.model.controllers;

import com.dam.chatsocket_java.App;
import com.dam.chatsocket_java.model.DAOs.UsersDAO;
import com.dam.chatsocket_java.model.domain.Msg;
import com.dam.chatsocket_java.model.domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomController implements Initializable {

    @FXML
    private Pane navbar;
    @FXML
    private Button closeButton;
    @FXML
    private TextArea msgArea;
    @FXML
    private TableView<Msg> msgTable;
    @FXML
    private TableColumn userColumn;
    @FXML
    private TableColumn msgColumn;
    @FXML
    private TableColumn dateColumn;
    @FXML
    private TableView<Msg> userTable;
    @FXML
    private TableColumn allUserColumn;




    private ObservableList<Msg> mensajes;
    private ObservableList<User> usuarios;
    private double xOffset = 0;
    private double yOffset = 0;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        navbar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        navbar.setOnMouseDragged(event -> {
            Stage stage = (Stage) navbar.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        mensajes = FXCollections.observableArrayList();
        this.userColumn.setCellValueFactory(new PropertyValueFactory("userName"));
        this.msgColumn.setCellValueFactory(new PropertyValueFactory("msgContent"));
        this.dateColumn.setCellValueFactory(new PropertyValueFactory("date"));

        usuarios = FXCollections.observableArrayList();
        this.allUserColumn.setCellValueFactory(new PropertyValueFactory("name"));

        generateMsgTable();
    }


    public void closeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void minimizeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    public void goBack() {
        try {
            App.setRoot("home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() {

    }

    @FXML
    public void generateMsgTable() {
        List<Msg> aux = null;
//        try {
//            aux = cdao.findAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        clases.setAll(aux);
//
//        this.msgTable.setItems(clases);
    }

    @FXML
    public void generateUserTable() {
        List<User> aux = null;
//        try {
//            aux = cdao.findAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        clases.setAll(aux);
//
//        this.msgTable.setItems(clases);
    }

}
