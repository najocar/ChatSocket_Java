package com.dam.chatsocket_java.model.domain;


import java.util.List;
import java.util.Objects;

public class Room {
    int idRoom;
    List<User> usersList;
    List<Msg> msgList;

    public Room(int idRoom, List<User> usersList, List<Msg> msgList) {
        this.idRoom = idRoom;
        this.usersList = usersList;
        this.msgList = msgList;
    }

    public Room() {
        this.idRoom = 0;
        this.usersList = null;
        this.msgList = null;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<Msg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return idRoom == room.idRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom);
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", usersList=" + usersList +
                ", msgList=" + msgList +
                '}';
    }
}
