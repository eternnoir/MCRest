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

    public Player(OfflinePlayer bukkitPlayer){
        this.name= bukkitPlayer.getName();
        this.uniqueId= bukkitPlayer.getUniqueId();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }
}
