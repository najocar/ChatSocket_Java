package com.dam.chatsocket_java.model.dto;

import com.dam.chatsocket_java.model.domain.User;

public class UserDTO {

    /**
     * This Class is a DTO(Singleto) for the User Class.
     */

    private static UserDTO _newInstance; // This is instance for the Singleton
    private static User _user;

    private UserDTO(User user){
        _user = user;
    }

    public static User getUser(){
        if(_newInstance == null){
            _newInstance = new UserDTO(null);
        }
        return _user;
    }

    public static void setUser(User user){
        _newInstance = new UserDTO(user);
    }

}
