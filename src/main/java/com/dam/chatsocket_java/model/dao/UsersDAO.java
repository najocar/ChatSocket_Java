package com.dam.chatsocket_java.model.dao;

import com.dam.chatsocket_java.model.connections.ConnectionXML;
import com.dam.chatsocket_java.model.domain.User;
import com.dam.chatsocket_java.model.domain.Users;
import com.dam.chatsocket_java.utils.LoggerClass;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class UsersDAO {
    static ConnectionXML con = new ConnectionXML();
    static LoggerClass logger = new LoggerClass(UsersDAO.class.getName());


    public boolean writeUser(User user){
        boolean result = false;
            try {
                Users userList = con.loadXMLUsers();
                if(user != null && userList != null){
                    userList.setUser(user);
                    con.writeXMLUser(userList);
                    result = true;
                }
            } catch (JAXBException | IOException e) {
                logger.warning("Error overwritten or reading Users.xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
            }
        return result;
    }

    public boolean writeUser(Users users){
        boolean result = false;
        if(users != null) {
            try {
                con.writeXMLUser(users);
                result = true;
            } catch (JAXBException | IOException e) {
                logger.warning("Error overwrite Users.xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
            }
        }
        return result;
    }

    public Users readUsers(){
        Users result = new Users();
        try {
            result = con.loadXMLUsers();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean removeUser(User user){
        boolean result = false;
            try {
                Users aux = con.loadXMLUsers();
                if(user != null && aux != null){
                    aux.getUsers().remove(user);
                    con.writeXMLUser(aux);
                    result = true;
                }
            } catch (JAXBException | IOException e) {
                logger.warning("Error overwrite or reading Users.xml file");
            } catch (Exception e){
                logger.warning("An unexpected error has occurred");
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
