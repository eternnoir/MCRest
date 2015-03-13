package org.mcrest.server;

import org.mcrest.entity.Player;
import org.mcrest.entity.World;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/3.
 */
public interface IServer {
    /**
     * Get all players. Contain offline and online.
     * @return
     */
    public Collection<? extends Player>  getPlayers();
    public Collection<? extends World>  getWorlds();

    /**
     * Get online players only.
     * @return
     */
    public Collection<? extends Player> getOnlinePlayers();

    public Collection<? extends Player> getOfflinePlayers();

    public Player getPlayer(String playerName);

    public Logger getLogger();
}
