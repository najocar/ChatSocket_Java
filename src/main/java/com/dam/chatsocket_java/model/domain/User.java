package com.dam.chatsocket_java.model.domain;

import java.util.Objects;

public class User {
    private String name;
    private int currentRoom;

    public User(String name, int currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public User() {
        this.name = "";
        this.currentRoom = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", currentRoom=" + currentRoom +
                '}';
    }
}
