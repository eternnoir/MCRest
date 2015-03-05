package org.mcrest.entity;

import org.bukkit.OfflinePlayer;

import java.io.Serializable;
import java.util.UUID;

/**
 * Player class is model in minecraft game. It has some attribute for Rest Ues.
 *
 * Created by frank on 2015/3/3.
 */
public class Player implements Serializable {
    private String name;
    private UUID uniqueId;
    private boolean online;
    private boolean whitelisted;
    private boolean banned;
    private long firstPlayed;
    private long lastPlayed;


    public Player(OfflinePlayer bukkitPlayer){
        this.name= bukkitPlayer.getName();
        this.uniqueId= bukkitPlayer.getUniqueId();
        this.online = bukkitPlayer.isOnline();
        this.whitelisted = bukkitPlayer.isWhitelisted();
        this.banned = bukkitPlayer.isBanned();
        this.firstPlayed = bukkitPlayer.getFirstPlayed();
        this.lastPlayed = bukkitPlayer.getLastPlayed();
    }

    public Player(){}

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public boolean isOnline() {
        return online;
    }

    public boolean isWhitelisted() {
        return whitelisted;
    }

    public boolean isBanned() {
        return banned;
    }

    public long getFirstPlayed() {
        return firstPlayed;
    }
}
