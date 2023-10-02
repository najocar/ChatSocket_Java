package com.dam.chatsocket_java.model;

import com.dam.chatsocket_java.model.dao.RoomDAO;
import com.dam.chatsocket_java.model.dao.RoomsDAO;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;
import com.dam.chatsocket_java.model.dto.RoomsDataDTO;
import com.dam.chatsocket_java.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class testMain {

    static UsersDAO usersDAO = new UsersDAO(); // finalizado
    static RoomsDAO roomsDAO = new RoomsDAO(); // finalizado
    static RoomDAO roomDAO = new RoomDAO(); // finalizado

    public static void main(String[] args) {

        for(RoomsDataDTO aux: testRoomDataDTO()){
            System.out.println(aux);
        }

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
