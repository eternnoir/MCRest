package org.mcrest;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.application.RestApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by frank on 2015/3/3.
 */
public class Main {
    public static void main(String[] args) {
        // Create a new Component
        Component component = new Component();
        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);
        // Attach the sample application.
        component.getDefaultHost().attach("/server", new RestApplication());
        // Start the component.
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
