package com.dam.chatsocket_java.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import com.dam.chatsocket_java.model.connections.LocalDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "msg")
public class Msg implements Serializable {
    private String userName;
    private String msgContent;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
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
