package com.dam.chatsocket_java;

import com.dam.chatsocket_java.model.dao.RoomDAO;
import com.dam.chatsocket_java.model.dao.RoomsDAO;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;
import com.dam.chatsocket_java.model.dto.RoomsDataDTO;
import com.dam.chatsocket_java.model.dto.UserDTO;
import com.dam.chatsocket_java.utils.LoggerClass;

import java.util.ArrayList;
import java.util.List;

public class testMain {


    static UsersDAO usersDAO = new UsersDAO(); // finalizado
    static RoomsDAO roomsDAO = new RoomsDAO(); // finalizado
    static RoomDAO roomDAO = new RoomDAO(); // finalizado

    static LoggerClass logger = new LoggerClass(testMain.class.getName());

    public static void main(String[] args) {
        Runnable fileReadingTask = () -> {
            while(true){
                try {
                    for(RoomsDataDTO aux: testRoomDataDTO()){
                        System.out.println(aux);
                    }
                    Thread.sleep(5000);
                } catch (InterruptedException | IllegalArgumentException e) {
                    Thread.currentThread().interrupt();
                    logger.info("El hilo a dejado de ejecutarse");
                    break;
                }
            }
        };

        Thread thread = new Thread(fileReadingTask);
        thread.start();

    }

    public static List<RoomsDataDTO> testRoomDataDTO(){
        List<RoomsDataDTO> result = new ArrayList<>();
        Users usuarios = usersDAO.readUsers();
        Rooms rooms = roomsDAO.readRooms();

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
}
