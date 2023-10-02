package com.dam.chatsocket_java.model.dto;

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

    @Override
    public String toString() {
        return "RoomsDataDTO{" +
                "roomName='" + roomName + '\'' +
                ", usersLenght=" + usersLenght +
                '}';
    }
}
