package com.dam.chatsocket_java.controllers;

import com.dam.chatsocket_java.App;
import com.dam.chatsocket_java.model.dao.RoomDAO;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.*;
import com.dam.chatsocket_java.model.dto.UserDTO;
import com.dam.chatsocket_java.utils.LoggerClass;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private TableView<User> userTable;
    @FXML
    private TableColumn allUserColumn;




    private ObservableList<Msg> mensajes;
    private ObservableList<User> usuarios;
    private double xOffset = 0;
    private double yOffset = 0;
    private boolean finish = true;


    RoomDAO roomDAO = new RoomDAO();
    UsersDAO usersDAO = new UsersDAO();

    static LoggerClass logger = new LoggerClass(RoomController.class.getName());

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

        reloadTables();
        refreshTables(() -> reloadTables());
    }

    public void reloadTables(){
        generateMsgTable(UserDTO.getUser().getCurrentRoom());
        generateUserTable(UserDTO.getUser().getCurrentRoom());
    }


    public void closeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        usersDAO.removeUser(UserDTO.getUser());
        finish = false;
        stage.close();
    }

    public void minimizeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    public void goBack() {
        try {
            App.setRoot("changeRoom");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() {
        String text = msgArea.getText();
        Msg msg = new Msg(UserDTO.getUser().getName(), text, LocalTime.now().withNano(0));
        Room room = roomDAO.readRoom(new Room(UserDTO.getUser().getCurrentRoom()));
        MsgsList msgs = room.getMsgList();
        msgs.addMsg(msg);
        room.setMsgList(msgs);
        roomDAO.writeRoom(room);
        clearField();
        reloadTables();
    }

    public void clearField(){
        msgArea.setText("");
    }

    @FXML
    public void generateMsgTable(int room) {

        mensajes.setAll(roomDAO.readRoom(new Room(room)).getMsgList().getMsgs());

        this.msgTable.setItems(mensajes);
    }

    @FXML
    public void generateUserTable(int room) {
        usuarios.setAll(usersDAO.readUsers().usersInRoom(room));
        this.userTable.setItems(usuarios);
    }

    public void refreshTables(Runnable runnable) {
        new Thread(() -> {
            while (finish) {
                try {
                    Thread.sleep(1000);
                    runnable.run();
                } catch (Exception e) {
                    logger.warning("The secondary thread has been interrupted");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
