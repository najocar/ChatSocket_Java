package com.dam.chatsocket_java.model.DAOs;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;

import java.io.Serializable;

public class RoomsDAO implements Serializable {

    private static ConnectionXML connection = new ConnectionXML();

    public boolean createRoom(Room room){
        boolean result = false;
        if(room != null){
            connection.loadXMLRooms();
        }
        return result;
    }

}
