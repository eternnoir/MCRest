package org.mcrest.server;

import org.bukkit.entity.Player;

/**
 * Created by frank on 2015/3/3.
 */
public class BukkitServer implements IServer {
    @Override
    public Player[] getPlayers() {
        return new Player[0];
    }
}
