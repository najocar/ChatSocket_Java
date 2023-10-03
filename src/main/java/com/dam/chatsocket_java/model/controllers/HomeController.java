package com.dam.chatsocket_java.model.controllers;

import com.dam.chatsocket_java.App;
import com.dam.chatsocket_java.model.dao.RoomsDAO;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.RoomsList;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.UsersList;
import com.dam.chatsocket_java.model.dto.RoomsDataDTO;
import com.dam.chatsocket_java.model.dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private TableView<RoomsDataDTO> roomTable;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn usersColumn;


    private ObservableList<RoomsDataDTO> rooms;

    private double xOffset = 0;
    private double yOffset = 0;

    private UsersDAO usersDao = new UsersDAO();
    private RoomsDAO roomsDao = new RoomsDAO();

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

        rooms = FXCollections.observableArrayList();
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("roomName"));
        this.usersColumn.setCellValueFactory(new PropertyValueFactory("usersLenght"));

        generateRoomsTable();
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
            if (validateName(fieldUser.getText()) && selectRoom() != ""){

                controlUser(fieldUser.getText(), Integer.parseInt(selectRoom()));
                System.out.println(UserDTO.getUser());
                App.setRoot("room");
            }else {
                // usuario existe
                System.out.println("el usuario ya existe, pon otro");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void controlUser(String name, int room) {
        User user = new User(name);
        user.setCurrentRoom(room);

        UserDTO.setUser(user);
        usersDao.writeUser(user);
    }

    public boolean validateName(String name) {
        if (!name.isEmpty() && !usersDao.userExist(name)){
            return true;
        }
        return false;
    }

    public List<RoomsDataDTO> getAllRooms(){
        List<RoomsDataDTO> result = new ArrayList<>();
        UsersList usuarios = usersDao.readUsers();
        RoomsList rooms = roomsDao.readRooms();

        for(String room: rooms.getRooms()){
            int userLenght = 0;
            for(User user: usuarios.getUsers()){
                if(room.equals(String.valueOf(user.getCurrentRoom()))){
                    userLenght++;
                }
            }
            result.add(new RoomsDataDTO(room, userLenght));
        }
        return result;
    }

    @FXML
    public void generateRoomsTable() {
        List<RoomsDataDTO> aux = getAllRooms();
        rooms.setAll(aux);
        this.roomTable.setItems(rooms);
    }

    @FXML
    public String selectRoom(){
        String result = "";
        RoomsDataDTO aux = this.roomTable.getSelectionModel().getSelectedItem();
        if (aux != null){
            result = aux.getRoomName();
        }else {
            System.out.println("selecciona sala");
        }
        return result;
    }

}