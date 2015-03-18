package org.mcrest.application.resources;


import org.bukkit.Bukkit;
import org.mcrest.ServerManager;
import org.mcrest.entity.ServerStatus;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

/**
 * By Default return server status.
 * Created by frank on 2015/3/3.
 */
public class MainResource extends ServerResource {
    private Logger logger;
    @Override
    public void doInit(){
        logger = ServerManager.getInstance().getServer().getLogger();
    }
    @Get("json")
    public Representation getRepresentation() {
        logger.info("GET Server Status");
        ServerStatus serverStatus = ServerManager.getInstance().getServer().getServerStatus();
        return new JacksonRepresentation<ServerStatus>(serverStatus);
    }
}
