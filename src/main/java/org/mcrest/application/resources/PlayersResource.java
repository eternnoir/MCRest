package org.mcrest.application.resources;

import org.mcrest.ServerManager;
import org.mcrest.entity.Player;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import java.util.Collection;

/**
 * Created by frank on 2015/3/3.
 */
public class PlayersResource extends ServerResource {
    String userName;

    Object player;

    @Override
    public void doInit() {
        this.userName = getAttribute("user");
        this.player = null; // Could be a lookup to a domain object.
    }

    @Get("json")
    public Representation getRepresentation() {
        Collection<? extends Player> players = ServerManager.getInstance().getServer().getPlayers();
        return new JacksonRepresentation<Collection<?extends Player>>(players);
    }
}
