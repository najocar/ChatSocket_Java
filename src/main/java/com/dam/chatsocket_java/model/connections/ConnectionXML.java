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

    /**
     * Method to load all rooms from rooms.xml file
     * @return Rooms
     * @throws IllegalArgumentException
     * @throws JAXBException
     */
    public Rooms loadXMLRooms() throws IllegalArgumentException, JAXBException{
        Rooms result = null;
        if(fileRooms.exists()){
            JAXBContext jc = JAXBContext.newInstance(Rooms.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Rooms) unmarshaller.unmarshal(fileRooms);
        }
        return result;
    }

    /**
     * Method to overwrite rooms.xml file passed by param
     * @param rooms
     * @throws JAXBException
     * @throws IOException
     */
    public void writeXMLRooms(Rooms rooms) throws JAXBException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRooms))) {
            JAXBContext jc = JAXBContext.newInstance(Rooms.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(rooms, writer);
        }
    }

    /**
     * Method to overwrite users.xml file passed by param
     * @param userList
     * @throws JAXBException
     * @throws IOException
     */
    public void writeXMLUser(Users userList) throws JAXBException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsers))) {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userList, writer);
        }
    }

    /**
     * Method to load all users from users.xml file
     * @return Users
     * @throws IllegalArgumentException
     * @throws JAXBException
     */
    public Users loadXMLUsers() throws IllegalArgumentException, JAXBException{
        Users result = null;
        if(fileUsers.exists()){
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Users) unmarshaller.unmarshal(fileUsers);
        }
        return result;
    }

    /**
     * Method to load room from room_[].xml file passed by param
     * @param room
     * @return Room
     * @throws IllegalArgumentException
     * @throws JAXBException
     */
    public Room loadXMLRoom(Room room) throws IllegalArgumentException, JAXBException{
        Room result = null;
        if(room != null){
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Room) unmarshaller.unmarshal(new File("room_"+room.getIdRoom()+".xml"));
        }
        return result;
    }

    /**
     * Method to overwrite room[].xml file passed by param
     * @param room
     * @throws IOException
     * @throws JAXBException
     */
    public void writeXMLRoom(Room room) throws IOException, JAXBException{
        if(room != null){
            try (FileWriter writer = new FileWriter("room_"+room.getIdRoom()+".xml")){
                JAXBContext jc = JAXBContext.newInstance(Room.class);
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(room, writer);
            }
        }
    }

}