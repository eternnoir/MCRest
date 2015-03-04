package org.mcrest.entity;

/**
 * Created by frank on 2015/3/4.
 */
public class OnlinePlayer extends Player{
    private String dispalyName;

    public OnlinePlayer(org.bukkit.entity.Player bukkitPlayer) {
        super(bukkitPlayer);
        this.dispalyName = bukkitPlayer.getDisplayName();
    }

    public String getDispalyName() {
        return dispalyName;
    }

    public void setDispalyName(String dispalyName) {
        this.dispalyName = dispalyName;
    }
}
