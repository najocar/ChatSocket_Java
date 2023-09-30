package com.dam.chatsocket_java.model.connections;

import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.Rooms;
import com.dam.chatsocket_java.model.domain.Users;

import javax.xml.bind.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConnectionXML {
    static final File fileRooms = new File("rooms.xml");
    static final File fileUsers = new File("users.xml");

    public ConnectionXML() {}

    public Rooms loadXMLRooms() {
        Rooms result = null;
        if(fileRooms.exists()){
            try {
                JAXBContext jc = JAXBContext.newInstance(Rooms.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                result = (Rooms) unmarshaller.unmarshal(fileRooms);
            } catch (IllegalArgumentException | JAXBException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void writeXMLRooms(Rooms rooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRooms))) {
            JAXBContext jc = JAXBContext.newInstance(Rooms.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(rooms, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeXMLUser(Users userList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsers))) {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userList, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public Users loadXMLUsers() {
        Users result = null;
        if(fileUsers.exists()){
            try {
                JAXBContext jc = JAXBContext.newInstance(Users.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                result = (Users) unmarshaller.unmarshal(fileUsers);
            } catch (IllegalArgumentException | JAXBException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Room loadXMLRoom(Room room) {
        Room result = null;
        if(room != null){
            try {
                JAXBContext jc = JAXBContext.newInstance(Room.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                result = (Room) unmarshaller.unmarshal(new File("room_"+room.getIdRoom()+".xml"));
            }catch (IllegalArgumentException | JAXBException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void writeXMLRoom(Room room){
        if(room != null){
            try (FileWriter writer = new FileWriter("room_"+room.getIdRoom()+".xml")){
                JAXBContext jc = JAXBContext.newInstance(Room.class);
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(room, writer);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
    }

}