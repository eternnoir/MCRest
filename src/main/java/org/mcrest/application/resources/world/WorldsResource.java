package org.mcrest.application.resources.world;

import org.mcrest.ServerManager;
import org.mcrest.entity.World;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.Collection;

/**
 * Created by frank on 2015/3/13.
 */
public class WorldsResource  extends ServerResource {
    @Override
    public void doInit() {
    }

    @Get("json")
    public Representation getRepresentation() {
        Collection<? extends World> worlds= ServerManager.getInstance().getServer().getWorlds();
        return new JacksonRepresentation<Collection<?extends World>>(worlds);
    }
}
