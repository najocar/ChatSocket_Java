package com.dam.chatsocket_java.model.dto;

import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;

import java.util.ArrayList;
import java.util.List;

public class RoomsDataDTO {
    /**
     * This Class is a DTO for the ObervableList in the View
     */

    private String roomName;
    private int usersLenght;

    public RoomsDataDTO(){
        this.roomName = "";
        this.usersLenght = 0;
    }

    public RoomsDataDTO(String room, int users){
        this.roomName = room;
        this.usersLenght = users;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getUsersLenght() {
        return usersLenght;
    }

    public void setUsersLenght(int usersLenght) {
        this.usersLenght = usersLenght;
    }

    @Override
    public String toString() {
        return "RoomsDataDTO{" +
                "roomName='" + roomName + '\'' +
                ", usersLenght=" + usersLenght +
                '}';
    }

}
