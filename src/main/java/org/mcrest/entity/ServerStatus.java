package org.mcrest.entity;

import org.bukkit.Server;

import java.io.Serializable;

/**
 * The server status class. It has some attribute to show the server status.
 *
 * Created by frank on 2015/3/13.
 */
public class ServerStatus implements Serializable {
    private String	bukkitVersion;
    private String	name;
    private String	serverName;
    public ServerStatus(Server bserver){
        this.bukkitVersion = bserver.getBukkitVersion();
        this.name = bserver.getName();
        this.serverName = bserver.getServerName();
    }

    public ServerStatus(){

    }

    public void setBukkitVersion(String bukkitVersion){
        this.bukkitVersion = bukkitVersion;
    }

    public String getBukkitVersion() {
        return bukkitVersion;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setServerName(String serverName){
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }
}
