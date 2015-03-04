package org.mcrest.server;

import org.mcrest.entity.Player;

/**
 * Created by frank on 2015/3/3.
 */
public interface IServer {
    public Player[] getPlayers();
    public Player[] getOnlinePlayers();
}
