package org.mcrest.server;

import org.bukkit.Bukkit;
import org.mcrest.entity.Player;

import java.util.Collection;

/**
 * The Server bukkit version,
 * Created by frank on 2015/3/3.
 */
public class BukkitServer implements IServer {
    @Override
    public Player[] getPlayers() {
        // TODO not imp.
        return new Player[0];
    }

    @Override
    public Player[] getOnlinePlayers() {
        Collection<? extends org.bukkit.entity.Player> onlinePlayers = Bukkit.getOnlinePlayers();
        return new Player[0];
    }
}
