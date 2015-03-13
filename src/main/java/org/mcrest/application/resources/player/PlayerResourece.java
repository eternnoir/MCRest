package org.mcrest.application.resources.player;

import org.mcrest.ServerManager;
import org.mcrest.entity.Player;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/5.
 */
public class PlayerResourece extends ServerResource  {
    private String playerName;
    private Object player;
    private Logger logger;
    @Override
    public void doInit() {
        this.playerName = getAttribute("name");
        logger = ServerManager.getInstance().getServer().getLogger();
        this.player = null; // Could be a lookup to a domain object.
    }

    @Get("json")
    public Representation getRepresentation() {
        logger.info("get player id "+playerName+" info.");
        Player player = ServerManager.getInstance().getServer().getPlayer(playerName);
        logger.info("get player "+player.getName()+" info success.");
        return new JacksonRepresentation<Player>(player);
    }
}
