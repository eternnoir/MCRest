package org.mcrest;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.application.RestApplication;
import org.mcrest.server.bukkit.BukkitServer;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by frank on 2015/3/3.
 */
public class McRest extends JavaPlugin {
    @Override
    public void onEnable(){
        this.getLogger().info("Enable");
        // Set Bukkit Server.
        ConfigHandler.getInstance().setConfigByPlugin(this);
        ServerManager.getInstance().setServer(new BukkitServer(this));
        try{
            startServices();
            this.getLogger().info("McRest start success.");
            this.getLogger().info("Listen on 0.0.0.0:"+ConfigHandler.getInstance().getPort()+"/"+ConfigHandler.getInstance().getPrefix());
        }catch (Exception e){
            this.getLogger().warning(e.toString());
        }
    }
    @Override
    public void onDisable(){
        this.getLogger().info("McRest disabled");
        ConfigHandler.getInstance().saveConfig();
    }

    public void startServices() throws Exception {
        // Create a new Component
        Component component = new Component();
        // Add a new HTTP server listening on port which from config file.
        // If first init the port is 8281.
        component.getServers().add(Protocol.HTTP, ConfigHandler.getInstance().getPort());
        // Attach the sample application.
        component.getDefaultHost().attach("/"+ConfigHandler.getInstance().getPrefix(), new RestApplication());
        // Start the component.
        component.start();
    }
}
