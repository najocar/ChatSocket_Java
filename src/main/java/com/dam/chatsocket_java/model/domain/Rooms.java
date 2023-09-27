package com.dam.chatsocket_java.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rooms")
public class Rooms implements Serializable {

    @XmlElement(name = "room", type=String.class)
    private List<String> roomsId;

    public Rooms() {
        this.roomsId = new ArrayList<>();
    }

    public Rooms(List<String> roomList) {
        this.roomsId = roomList;
    }

    public List<String> getRooms() {
        return roomsId;
    }

    public void setRoom(List<String> roomsId) {
        this.roomsId = roomsId;
    }

    public void setRoom(String roomId){
        this.roomsId.add(roomId);
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "rooms=" + roomsId +
                '}';
    }
}
