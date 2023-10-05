package com.dam.chatsocket_java.model.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "settings")
public class Settings {
    private String fileRooms;
    private String fileUsers;
    private String pathFileRoom;

    public Settings(){
        this.fileRooms = "////PORTATIL-1//CarpetaCompartida/rooms.xml";
        this.fileUsers = "////PORTATIL-1//CarpetaCompartida/users.xml";
        this.pathFileRoom = "////PORTATIL-1//CarpetaCompartida/rooms/";
    }

    public Settings(String fileRooms, String fileUsers, String pathFileRoom){
        this.fileRooms = fileRooms;
        this.fileUsers = fileUsers;
        this.pathFileRoom = pathFileRoom;
    }

    public String getFileRooms() {
        return fileRooms;
    }

    public void setFileRooms(String fileRooms) {
        this.fileRooms = fileRooms;
    }

    public String getFileUsers() {
        return fileUsers;
    }

    public void setFileUsers(String fileUsers) {
        this.fileUsers = fileUsers;
    }

    public String getPathFileRoom() {
        return pathFileRoom;
    }

    public void setPathFileRoom(String pathFileRoom) {
        this.pathFileRoom = pathFileRoom;
    }

    @Override
    public String toString() {
        return "Config{" +
                "fileRooms='" + fileRooms + '\'' +
                ", fileUsers='" + fileUsers + '\'' +
                ", pathFileRoom='" + pathFileRoom + '\'' +
                '}';
    }
}
