package org.mcrest.utils;

import org.bukkit.OfflinePlayer;
import org.mcrest.entity.OnlinePlayer;
import org.mcrest.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by frank on 2015/3/4.
 */
public class PlayerHelper {
    public static Collection<? extends Player> convertBukkitPlayerToMcRest(  Collection<? extends OfflinePlayer>  bukkitPlayers){
        ArrayList<Player> players = new ArrayList<Player>();
        for(OfflinePlayer bPlayer : bukkitPlayers){
            // If play is online player, cast to online player.
            // Bad way. Should be refactor it.
            if (bPlayer instanceof org.bukkit.entity.Player) {
                players.add(new OnlinePlayer((org.bukkit.entity.Player)bPlayer));
            }
            else {
                players.add(new Player(bPlayer));
            }
        }
        return players;
    }
}
