package org.mcrest;

import org.mcrest.entity.Message;
import org.mcrest.entity.Player;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.World;
import org.mcrest.server.IServer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StubMCServer implements IServer {

    private Boolean whiteListEnable;
    private List<Message> messageList = new ArrayList<Message>();

    @Override
    public ServerStatus getServerStatus() {
        ServerStatus ss = new ServerStatus();
        ss.setName("MCStub");
        return ss;
    }

    @Override
    public Collection<? extends Player> getPlayers() {
        return null;
    }

    @Override
    public Collection<? extends World> getWorlds() {
        ArrayList<World> worlds = new ArrayList<World>();
        worlds.add(new World("testWorld"));
        return worlds;
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return null;
    }

    @Override
    public Collection<? extends Player> getOfflinePlayers() {
        return null;
    }

    @Override
    public Collection<? extends Player> getWhiteListPlayers() {
        return null;
    }

    @Override
    public void setPlayerToWhiteList(String userNameuuid, Boolean inWhitelist) {

    }

    @Override
    public List<Message> getMessages(int numOfMessage) {
        if(this.messageList.size()<numOfMessage){
            return this.messageList;
        }else {
            return this.messageList.subList(
                    this.messageList.size()-numOfMessage,messageList.size());
        }
    }

    @Override
    public Boolean hasWhiteList() {
        return whiteListEnable;
    }

    @Override
    public void setWhiteList(Boolean enable) {
        this.whiteListEnable = enable;
    }

    @Override
    public Player getPlayer(String playerName) {
        return null;
    }

    @Override
    public Logger getLogger() {
        Logger log = Logger.getLogger("UT");
        log.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        log.addHandler(handler);
        return log;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
