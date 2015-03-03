package org.mcrest;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.application.RestApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by frank on 2015/3/3.
 */
public class McRest extends JavaPlugin {


    @Override
    public void onEnable(){
        this.getLogger().info("Enable");
        try{
            startServices();
            this.getLogger().info("Rest start success.");
        }catch (Exception e){
            this.getLogger().warning(e.toString());
        }
    }

    @Override
    public void onDisable(){

    }

    public void startServices() throws Exception {
        // Create a new Component
        Component component = new Component();
        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);
        // Attach the sample application.
        component.getDefaultHost().attach("/server", new RestApplication());
        // Start the component.
        component.start();
    }
}
