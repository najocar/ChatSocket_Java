package com.dam.chatsocket_java.model.DAOs;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;

import java.io.Serializable;

public class RoomsDAO implements Serializable {

    private static ConnectionXML connection = new ConnectionXML();

    public boolean writeRoom(Room room){
        boolean result = false;
        if(room != null){
            Rooms rooms = connection.loadXMLRooms();
            rooms.setRoom(String.valueOf(room.getIdRoom()));
            connection.writeXMLRooms(rooms);
            result = true;
        }
        return result;
    }

    public boolean writeRoom(Rooms rooms){
        boolean result = false;
        if(rooms != null){
            connection.writeXMLRooms(rooms);
            result = true;
        }
        return result;
    }

    public Rooms loadRooms(){
        return connection.loadXMLRooms();
    }

    public boolean removeRooms(Room room){
        boolean result = false;
        if(room != null){
            Rooms rooms = connection.loadXMLRooms();
            rooms.getRooms().remove(String.valueOf(room.getIdRoom()));
            connection.writeXMLRooms(rooms);
            result = true;
        }
        return result;
    }
}
