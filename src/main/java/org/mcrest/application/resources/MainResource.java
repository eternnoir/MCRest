package org.mcrest.application.resources;


import org.bukkit.Bukkit;
import org.mcrest.ServerManager;
import org.mcrest.entity.ServerStatus;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by frank on 2015/3/3.
 */
public class MainResource extends ServerResource {
    @Get("json")
    public Representation getRepresentation() {
        ServerStatus serverStatus = ServerManager.getInstance().getServer().getServerStatus();
        return new JacksonRepresentation<ServerStatus>(serverStatus);
    }
}
