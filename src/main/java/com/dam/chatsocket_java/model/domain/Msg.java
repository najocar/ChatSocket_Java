package com.dam.chatsocket_java.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Msg {
    private String userName;
    private String msgContent;
    private LocalDate date;

    public Msg(String userName, String msgContent, LocalDate date) {
        this.userName = userName;
        this.msgContent = msgContent;
        this.date = date;
    }

    public Msg() {
        this.userName = "";
        this.msgContent = "";
        this.date = null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Msg msg = (Msg) o;
        return Objects.equals(userName, msg.userName) && Objects.equals(date, msg.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, date);
    }

    @Override
    public String toString() {
        return "Msg{" +
                "userName='" + userName + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", date=" + date +
                '}';
    }
}
