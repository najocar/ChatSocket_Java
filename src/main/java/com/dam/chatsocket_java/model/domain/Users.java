package com.dam.chatsocket_java.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users {

    @XmlElement(name = "user", type=User.class)
    private List<User> users;

    public Users(){
        this.users = new ArrayList<>();
    }

    public Users(List<User> userList){
        this.users = userList;
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void setUsersList(List<User> userList){
        this.users = userList;
    }

    public void setUser(User user){
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
