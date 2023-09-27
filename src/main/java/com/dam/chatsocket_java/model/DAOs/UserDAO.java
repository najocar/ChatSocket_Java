package com.dam.chatsocket_java.model.DAOs;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;

import java.util.List;

public class UserDAO {
    static ConnectionXML con = new ConnectionXML();

    public boolean createUser(User user){
        boolean result = false;
        if(user != null){
            Users userList = con.loadXMLUsers();
            userList.setUser(user);
            con.writeXMLUser(userList);
            result = true;
        }
        return result;
    }

    public boolean createUser(Users users){
        boolean result = false;
        if(users != null) {
            con.writeXMLUser(users);
            result = true;
        }
        return result;
    }

    public List<User> getUsers(){
        List<User> result = null;
        Users users = con.loadXMLUsers();
        result = users.getUsers();
        return result;
    }
}
