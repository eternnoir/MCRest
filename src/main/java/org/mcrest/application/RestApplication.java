package org.mcrest.application;


import org.mcrest.application.resources.MainResource;
import org.mcrest.application.resources.player.PlayerResourece;
import org.mcrest.application.resources.player.PlayersResource;
import org.mcrest.application.resources.world.WorldsResource;
import org.restlet.*;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;

/**
 * Created by frank on 2015/3/3.
 */
public class RestApplication extends Application {
    private ChallengeAuthenticator authenticatior;

    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        setUpRouter(router);
        return router;
    }

    /**
     * Set up Resource to routing.
     * @param router
     */
    private void setUpRouter(Router router) {
        router.attach("/", MainResource.class);
        router.attach("/player", PlayersResource.class);
        router.attach("/player/{{name}}", PlayerResourece.class);
        router.attach("/world", WorldsResource.class);
    }


    private ChallengeAuthenticator createAuthenticator() {
        ChallengeAuthenticator auth= new ChallengeAuthenticator(null, ChallengeScheme.HTTP_BASIC, "testRealm");
        MapVerifier mapVerifier = new MapVerifier();
        mapVerifier.getLocalSecrets().put("login", "secret".toCharArray());
        auth.setVerifier(mapVerifier);
        return auth;
    }

}
