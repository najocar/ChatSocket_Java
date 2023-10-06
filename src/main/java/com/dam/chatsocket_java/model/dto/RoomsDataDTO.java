package com.dam.chatsocket_java.model.dto;

/**
 * RoomsDataDTO Class (Singleton) instance to set and get data to users.xml and rooms.xml by connectionXML class
 */
public class RoomsDataDTO {

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
