package org.mcrest.application.resources;


import org.bukkit.Bukkit;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by frank on 2015/3/3.
 */
public class MainResource extends ServerResource {
    @Get
    public String toString() {
        Bukkit.getServer().getBukkitVersion();
        return "Hello MCRest.";
    }
}
