package org.mcrest.server.bukkit;


import org.mcrest.entity.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2015/4/3.
 */
public class MessageCenter {
    private static MessageCenter instance = new MessageCenter();
    private List<Message> chatMessageList;
    private int maxMessageNum;

    public MessageCenter(){
        chatMessageList = new ArrayList<org.mcrest.entity.Message>();
        this.maxMessageNum = Integer.MAX_VALUE;
    }
    public static MessageCenter getInstance() {
        // Do not use lazy init here.
        return instance;
    }

    public List<Message> getAllMessage(){
        return this.chatMessageList;
    }

    /**
     * Get number of messages. If all message number is lower than
     * numOfMessage. It will return all message list.
     * @param numOfMessage
     * @return
     */
    public List<Message> getMessages(int numOfMessage){
        if(this.chatMessageList.size()<numOfMessage){
            return this.chatMessageList;
        }
        int fromIndex = this.chatMessageList.size()-numOfMessage;
        return this.chatMessageList.subList(
                fromIndex,this.chatMessageList.size());
    }

    public synchronized void appendChatMessage(Message msg){
        // If message size over max. remove first message.
        if(chatMessageList.size()>maxMessageNum){
            chatMessageList.remove(0);
        }
        this.chatMessageList.add(msg);
    }

    public int getMaxMessageNum() {
        return maxMessageNum;
    }

    public void setMaxMessageNum(int maxMessageNum) {
        this.maxMessageNum = maxMessageNum;
    }
}
