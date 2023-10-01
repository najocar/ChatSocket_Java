package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Msg;
import com.dam.chatsocket_java.model.domain.Room;

import java.io.File;

public class RoomDAO {
    // room[].xml -> {
    //      roomId: string,
    //      msgs -> {
    //          msg: Msg
    //      }
    //  }
    ConnectionXML connection = new ConnectionXML();

    public Room readRoom(Room room){
        Room result = null;
        if(room != null){
            result = connection.loadXMLRoom(room);
        }
        return result;
    }

    public boolean writeRoom(Room room){
        boolean result = false;
        if(room != null){
            connection.writeXMLRoom(room);
            result = true;
        }
        return result;
    }

    public boolean writeMsg(Msg msg, Room room){
        boolean result = false;
        Room aux = connection.loadXMLRoom(room);
        if(msg != null && aux != null){
            aux.getMsgList().addMsg(msg);
            connection.writeXMLRoom(aux);
        }
        return result;
    }

    public boolean removeRoom(Room room){
        boolean result = false;
        if(room != null){
            try{
                File roomFile = new File("room_"+room.getIdRoom()+".xml");
                result = roomFile.delete();
            }catch (IllegalArgumentException e){
                System.out.println("El archivo no existe");
                e.printStackTrace();
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
