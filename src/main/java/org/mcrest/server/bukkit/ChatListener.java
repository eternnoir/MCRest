package org.mcrest.server.bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.entity.Message;
import org.mcrest.entity.Player;
import org.mcrest.utils.PlayerHelper;

/**
 * Created by frank on 2015/4/3.
 */
public class ChatListener implements Listener {

    private JavaPlugin plugin;
    public ChatListener(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void reviceChatMessage(AsyncPlayerChatEvent chatEventevent) {
        Player sender = PlayerHelper.convertToPlayer(chatEventevent.getPlayer());
        String content = chatEventevent.getMessage();
        Message msg = new Message(sender,content);
        MessageCenter.getInstance().appendChatMessage(msg);
        plugin.getLogger().info("GET CHAT MESSAGE: "+"["+sender.getName()+"]: "+msg);
    }
}
