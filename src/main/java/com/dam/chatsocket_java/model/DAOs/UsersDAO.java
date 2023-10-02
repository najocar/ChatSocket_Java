package com.dam.chatsocket_java.model.DAOs;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;

import java.util.List;

public class UsersDAO {
    static ConnectionXML con = new ConnectionXML();

    public boolean writeUser(User user){
        boolean result = false;
        Users userList = con.loadXMLUsers();
        if(user != null && userList != null){
            userList.setUser(user);
            con.writeXMLUser(userList);
            result = true;
        }
        return result;
    }

    public boolean writeUser(Users users){
        boolean result = false;
        if(users != null) {
            con.writeXMLUser(users);
            result = true;
        }
        return result;
    }

    public Users readUsers(){
        return con.loadXMLUsers();
    }

    public boolean removeUser(User user){
        boolean result = false;
        Users aux = con.loadXMLUsers();
        if(user != null && aux != null){
            aux.getUsers().remove(user);
            con.writeXMLUser(aux);
            result = true;
        }
        return result;
    }

    public boolean userExist(String name) {
        List<User> allUsers = readUsers().getUsers();
        for (User user: allUsers) {
            if (user.equals(new User(name))){
                return true;
            }
        }
        return false;
    }
}
