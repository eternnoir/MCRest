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
            players.add(convertToPlayer(bPlayer));
        }
        return players;
    }

    public static Player convertToPlayer(OfflinePlayer bukkitPlayer){
        if(bukkitPlayer.getPlayer()!=null){
            return new OnlinePlayer(bukkitPlayer.getPlayer());
        }
        else {
            return new Player(bukkitPlayer);
        }
    }


}
