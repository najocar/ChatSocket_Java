package com.dam.chatsocket_java.model.controllers;

import com.dam.chatsocket_java.App;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.Msg;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Pane navbar;
    @FXML
    private Button closeButton;
    @FXML
    private TextField fieldUser;
    @FXML
    private Button btnEnter;
    @FXML
    private TableView<Rooms> roomTable; //cambiar al dto
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn usersColumn;


    private ObservableList<User> rooms; //cambiar al dto

    private double xOffset = 0;
    private double yOffset = 0;

    private UsersDAO usersDao = new UsersDAO();

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

    public void goRoom() {
        try {
            if (validateName(fieldUser.getText())){
                App.setRoot("room");
            }else {
                // usuario existe
                System.out.println("el usuario ya existe, pon otro");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateName(String name) {
        if (!name.isEmpty() && !usersDao.userExist(name)){
            usersDao.writeUser(new User(name));
            return true;
        }
        return false;
    }


}