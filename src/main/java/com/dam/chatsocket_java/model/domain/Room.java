package com.dam.chatsocket_java.model.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "room")
public class Room implements Serializable {
    int idRoom;

    @XmlElement(name = "users", type=User.class)
    List<User> usersList;

    @XmlElement(name = "msgs", type=Msg.class)
    List<Msg> msgList;

    public Room(int idRoom) {
        this.idRoom = idRoom;
        this.usersList = new ArrayList<User>();
        this.msgList = new ArrayList<Msg>();
    }

    public Room() {
        this.idRoom = 0;
        this.usersList = new ArrayList<User>();
        this.msgList = new ArrayList<Msg>();
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
