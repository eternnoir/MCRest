package org.mcrest.application.resources;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Resource;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;

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
        ArrayList<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
        return new JacksonRepresentation<ArrayList<Player>>(players);
    }
}
