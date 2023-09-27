package com.dam.chatsocket_java.model.connections;

import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConnectionXML {
    static final File fileRooms = new File("rooms.xml");
    static final File fileUser = new File("users.xml");

    public ConnectionXML() {
    }

    public Room loadXMLRooms() {
        Room result = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Room) unmarshaller.unmarshal(fileRooms);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeXMLRooms(Room room) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRooms))) {
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(room, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeXMLUser(Users userList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUser))) {
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
        try {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Users) unmarshaller.unmarshal(fileUser);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }


}