package com.dam.chatsocket_java.model.connections;

import com.dam.chatsocket_java.model.domain.Room;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConnectionXML {
    static final File file = new File("rooms.xml");

    public ConnectionXML() {
    }

    public Room loadXML() {
        Room result = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Room) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeXML(Room room) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            JAXBContext jc = JAXBContext.newInstance(Room.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(room, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }


}