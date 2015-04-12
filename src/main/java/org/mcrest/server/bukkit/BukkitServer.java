package org.mcrest.server.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.entity.Message;
import org.mcrest.entity.Player;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.World;
import org.mcrest.server.IServer;
import org.mcrest.utils.PlayerHelper;
import org.mcrest.utils.WorldHelper;

import java.util.*;
import java.util.logging.Logger;


/**
 * The Server implement bukkit version, it will get information by
 * real minecraft server.
 * Created by frank on 2015/3/3.
 */
public class BukkitServer implements IServer {

    private JavaPlugin plugin;

    public BukkitServer(JavaPlugin plugin){
        this.plugin = plugin;
        regListener();
    }

    private void regListener(){
        Bukkit.getPluginManager().registerEvents(new ChatListener(plugin),plugin);
    }

    @Override
    public ServerStatus getServerStatus() {
        return new ServerStatus(Bukkit.getServer());
    }

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
    public Collection<? extends Player> getWhiteListPlayers() {
        Collection<? extends org.bukkit.OfflinePlayer> offlinePlayers = Bukkit.getServer().getWhitelistedPlayers();
        return PlayerHelper.convertBukkitPlayerToMcRest(offlinePlayers);
    }

    @Override
    public void setPlayerToWhiteList(String userNameuuid,Boolean inWhitelist) {
        OfflinePlayer player = Bukkit.getServer().getOfflinePlayer(userNameuuid);
        player.setWhitelisted(inWhitelist);
    }


    @Override
    public List<Message> getMessages(int numOfMessage) {
        return MessageCenter.getInstance().getMessages(numOfMessage);
    }

    @Override
    public Boolean hasWhiteList() {
        return Bukkit.getServer().hasWhitelist();
    }

    @Override
    public void setWhiteList(Boolean enable) {
        Bukkit.getServer().setWhitelist(enable);
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
        return this.plugin.getLogger();
    }
}
