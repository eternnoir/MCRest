package org.mcrest.application;


import org.mcrest.ConfigHandler;
import org.mcrest.ServerManager;
import org.mcrest.application.resources.MainResource;
import org.mcrest.application.resources.player.PlayerResourece;
import org.mcrest.application.resources.player.PlayersResource;
import org.mcrest.application.resources.world.WorldsResource;
import org.mcrest.utils.AuthPara;
import org.restlet.*;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;

import java.util.logging.Logger;

/**
 * Created by frank on 2015/3/3.
 */
public class RestApplication extends Application {
    private ChallengeAuthenticator authenticatior;
    private AuthPara authpara = null;
    private Logger logger;

    public RestApplication(){
        this.logger = ServerManager.getInstance().getServer().getLogger();
    }

    public RestApplication(AuthPara auth){
        this.logger = ServerManager.getInstance().getServer().getLogger();
        this.authpara = auth;
    }

    @Override
    public synchronized Restlet createInboundRoot() {
        authpara = ConfigHandler.getInstance().getAuthPara();
        Router router = new Router(getContext());
        setUpRouter(router);
        return router;
    }

    /**
     * Set up Resource to routing.
     * @param router
     */
    private void setUpRouter(Router router) {
        setUpAuth(router,"/","/",MainResource.class);
        setUpAuth(router,"/player","/player",PlayersResource.class);
        setUpAuth(router, "/player/{{name}}", "/player", PlayerResourece.class);
        setUpAuth(router, "/world", "/world", WorldsResource.class);
    }

    private void setUpAuth(Router router,String path,String resourceKey,Class<? extends ServerResource> targetClass){
        if(authpara == null ){
            router.attach(path,targetClass);
            return;
        }
        if((!authpara.isProtected(resourceKey))|| (!authpara.isEnabled())){
            router.attach(path,targetClass);
            return;
        }
        ChallengeAuthenticator auth = createAuthenticator();
        auth.setNext(targetClass);
        router.attach(path,auth);
        logger.info("Resource "+router+" need to auth.");
    }


    private ChallengeAuthenticator createAuthenticator() {
        ChallengeAuthenticator auth= new ChallengeAuthenticator(null, ChallengeScheme.HTTP_BASIC, "mcrest");
        MapVerifier mapVerifier = new MapVerifier();
        mapVerifier.getLocalSecrets().put("login", "secret".toCharArray());
        auth.setVerifier(mapVerifier);
        return auth;
    }

}
