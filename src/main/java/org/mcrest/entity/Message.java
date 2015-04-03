package org.mcrest.entity;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by frank on 2015/4/3.
 */
public class Message {
    private Player sender;
    private String message;
    private Date sendTime;

    public Message(){

    }

    public Message(Player sender,String message){
        this.sender = sender;
        this.message = message;
        this.sendTime = Calendar.getInstance().getTime();
    }

    public Player getSender() {
        return sender;
    }

    public void setSender(Player sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
