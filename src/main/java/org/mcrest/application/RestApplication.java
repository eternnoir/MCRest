package org.mcrest.application;


import org.mcrest.application.resources.MainResource;
import org.mcrest.application.resources.player.PlayerResourece;
import org.mcrest.application.resources.player.PlayersResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by frank on 2015/3/3.
 */
public class RestApplication extends Application {
    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/", MainResource.class);
        router.attach("/player", PlayersResource.class);
        router.attach("/player/{{name}}", PlayerResourece.class);
        return router;
    }
}
