package com.dam.chatsocket_java.model;

import com.dam.chatsocket_java.model.DAOs.UsersDAO;
import com.dam.chatsocket_java.model.domain.*;

public class testMain {
    public static void main(String[] args) {

//        RoomsDAO roomsDao = new RoomsDAO();
//       roomsDao.writeRoom(new Room(2));
//        roomsDao.removeRooms(new Room(2));
//
//
//        Rooms rooms = roomsDao.loadRooms();
//        System.out.println(rooms);

        UsersDAO userDAO = new UsersDAO();

        Users users = userDAO.getUsers();
        System.out.println(users);

        userDAO.removeUser(new User("usuario4"));
        users = userDAO.getUsers();
        System.out.println(users);

    }
}
