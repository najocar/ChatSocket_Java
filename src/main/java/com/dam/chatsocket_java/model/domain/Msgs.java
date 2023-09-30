package com.dam.chatsocket_java.model.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "msgs")
public class Msgs {

    @XmlElement(name = "msg", type=Msg.class)
    private List<Msg> msgs;

    public Msgs(){
        this.msgs = new ArrayList<>();
    }

    public Msgs(List<Msg> msgList){
        this.msgs = msgList;
    }

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }

    public void setMsgs(Msgs msgs){
        this.msgs = msgs.getMsgs();
    }

    public void addMsg(Msg msg){
        this.msgs.add(msg);
    }

    @Override
    public String toString() {
        return "Msgs{" +
                "msgs=" + msgs +
                '}';
    }
}
