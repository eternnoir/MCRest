package org.mcrest.server;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.mcrest.entity.Player;
import org.mcrest.utils.PlayerHelper;

import java.util.*;
import java.util.logging.Logger;

/**
 * The Server bukkit version,
 * Created by frank on 2015/3/3.
 */
public class BukkitServer implements IServer {
    @Override
    public Collection<? extends Player>  getPlayers() {
        // TODO not imp.
        return null;
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
    public Logger getLogger() {
        return Bukkit.getLogger();
    }
}
