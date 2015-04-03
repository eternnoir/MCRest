package org.mcrest.application.resources.chat;

import org.mcrest.ServerManager;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

/**
 * Created by frank on 2015/4/3.
 */
public class ChatResource extends ServerResource{
    private Logger logger;
        @Override
    public void doInit() {
        logger = ServerManager.getInstance().getServer().getLogger();
    }


    @Get("json")
    public Representation getRepresentation() {

        return new JacksonRepresentation<Player>(player);
    }
}
