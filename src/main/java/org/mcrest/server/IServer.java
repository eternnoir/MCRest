package org.mcrest.server;

import org.mcrest.entity.Player;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.World;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/3.
 */
public interface IServer {

    public ServerStatus getServerStatus();

    /**
     * Get all players. Contain offline and online.
     * @return
     */
    public Collection<? extends Player>  getPlayers();

    /**
     * Get server's world list.
     * @return worlds
     */
    public Collection<? extends World>  getWorlds();

    /**
     * Get online players only.
     * @return
     */
    public Collection<? extends Player> getOnlinePlayers();

    /**
     * Get offline players, but it will contain online player.
     * @return
     */
    public Collection<? extends Player> getOfflinePlayers();

    public Collection<? extends Player> getWhiteListPlayers();

    public Boolean hasWhiteList();

    public void setWhiteList(Boolean enable);

    /**
     * Get player by player name or uuid.
     * @param playerName or uuid
     * @return Player, if not found will return null.
     */
    public Player getPlayer(String playerName);

    public Logger getLogger();
}
