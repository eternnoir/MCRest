package org.mcrest.application.resources.whitelist;

import org.apache.logging.log4j.core.jmx.Server;
import org.mcrest.ServerManager;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.WhiteList;
import org.mcrest.server.IServer;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/24.
 */
public class WhiteListResource  extends ServerResource {
    private Logger logger;
    private IServer server;
    @Override
    public void doInit(){
        this.logger = ServerManager.getInstance().getServer().getLogger();
        this.server = ServerManager.getInstance().getServer();
    }
    @Get("json")
    public Representation getRepresentation() {
        logger.info("GET WhiteList");
        WhiteList wl = new WhiteList(server.hasWhiteList(),server.getWhiteListPlayers());
        return new JacksonRepresentation<WhiteList>(wl);
    }
}
