package org.mcrest.server;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.mcrest.entity.Player;
import org.mcrest.entity.World;
import org.mcrest.utils.PlayerHelper;
import org.mcrest.utils.WorldHelper;

import java.util.*;
import java.util.logging.Logger;

/**
 * The Server bukkit version,
 * Created by frank on 2015/3/3.
 */
public class BukkitServer implements IServer {
    @Override
    public Collection<? extends Player>  getPlayers() {
        return getOfflinePlayers();
    }

    @Override
    public Collection<? extends World> getWorlds() {
        Collection<? extends org.bukkit.World> bworlds = Bukkit.getWorlds();
        return WorldHelper.ConvertBukkitWorldToRest(bworlds);
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        Collection<? extends org.bukkit.OfflinePlayer> onlinePlayers = Bukkit.getOnlinePlayers();
        return PlayerHelper.convertBukkitPlayerToMcRest(onlinePlayers);
    }

    @Override
    public Collection<? extends Player> getOfflinePlayers() {
        Collection<? extends org.bukkit.OfflinePlayer> offlinePlayers =
                new ArrayList<OfflinePlayer>(Arrays.asList(Bukkit.getOfflinePlayers()));
        return PlayerHelper.convertBukkitPlayerToMcRest(offlinePlayers);
    }

    @Override
    public Player getPlayer(String playerName) {
        OfflinePlayer bukkitPlayer = Bukkit.getOfflinePlayer(playerName);
        Player player = null;
        if( bukkitPlayer!=null){
            player= PlayerHelper.convertToPlayer(bukkitPlayer);
        }
        return player;
    }

    @Override
    public Logger getLogger() {
        return Bukkit.getLogger();
    }
}
