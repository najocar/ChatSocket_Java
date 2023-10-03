package com.dam.chatsocket_java;

import com.dam.chatsocket_java.model.dao.RoomDAO;
import com.dam.chatsocket_java.model.dao.RoomsDAO;
import com.dam.chatsocket_java.model.dao.UsersDAO;
import com.dam.chatsocket_java.model.domain.Room;
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
        roomDAO.writeRoom(new Room(2));

    }


}
