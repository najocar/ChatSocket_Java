package com.dam.chatsocket_java.model;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.Msg;
import com.dam.chatsocket_java.model.domain.Room;
import com.dam.chatsocket_java.model.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testMain {
    public static void main(String[] args) {
        ConnectionXML connection = new ConnectionXML();

        User usuario = new User("usuario1");
        Msg mensaje = new Msg("usuario1", "Hola mundo", LocalDate.now());

        List<User> userList = new ArrayList<>();
        userList.add(usuario);
        List<Msg> msgList = new ArrayList<>();
        msgList.add(mensaje);

        //Room sala = new Room(1, userList, msgList);

        //connection.writeXML(sala);

        Room sala2 = connection.loadXML();
        System.out.println(sala2);

    }
}
