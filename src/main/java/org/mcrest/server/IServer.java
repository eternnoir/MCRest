package org.mcrest.server;

import org.mcrest.entity.Message;
import org.mcrest.entity.Player;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.World;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/3.
 */
public interface IServer {

    ServerStatus getServerStatus();

    /**
     * Get all players. Contain offline and online.
     * @return
     */
    Collection<? extends Player>  getPlayers();

    /**
     * Get server's world list.
     * @return worlds
     */
    Collection<? extends World>  getWorlds();

    /**
     * Get online players only.
     * @return
     */
    Collection<? extends Player> getOnlinePlayers();

    /**
     * Get offline players, but it will contain online player.
     * @return
     */
    Collection<? extends Player> getOfflinePlayers();

    Collection<? extends Player> getWhiteListPlayers();

    List<Message> getMessages(int numOfMessage);

    Boolean hasWhiteList();

    void setWhiteList(Boolean enable);

    /**
     * Get player by player name or uuid.
     * @param playerName or uuid
     * @return Player, if not found will return null.
     */
    Player getPlayer(String playerName);

    Logger getLogger();
}
