package org.mcrest.server;

import org.mcrest.entity.Player;

import java.util.Collection;

/**
 * Created by frank on 2015/3/3.
 */
public interface IServer {
    /**
     * Get all players. Contain offline and online.
     * @return
     */
    public Collection<? extends Player>  getPlayers();

    /**
     * Get online players only.
     * @return
     */
    public Collection<? extends Player> getOnlinePlayers();

    public Collection<? extends Player> getOfflinePlayers();
}
