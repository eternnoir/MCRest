package org.mcrest.application;


import org.mcrest.application.resources.MainResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by frank on 2015/3/3.
 */
public class RestApplication extends Application {
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());
        router.attach("/", MainResource.class);
        return router;
    }
}
