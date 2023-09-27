package com.dam.chatsocket_java.model.DAOs;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;

public class UsersDAO {
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

    public Users getUsers(){
        return con.loadXMLUsers();
    }

    public boolean removeUser(User user) {
        boolean result = false;
         Users users = con.loadXMLUsers();
         users.getUsers().remove(user);
         con.writeXMLUser(users);
        return result;
    }

}
