package org.mcrest.entity;

import org.bukkit.Server;

/**
 * Created by frank on 2015/3/13.
 */
public class ServerStatus {
    private String	bukkitVersion;
    private String	name;
    private String	serverName;
    public ServerStatus(Server bserver){
        this.bukkitVersion = bserver.getBukkitVersion();
        this.name = bserver.getName();
        this.serverName = bserver.getServerName();
    }

}
