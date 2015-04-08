package org.mcrest.application.resources.whitelist;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.mcrest.ServerManager;
import org.mcrest.application.resources.Result;
import org.mcrest.entity.Player;
import org.mcrest.server.IServer;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by frank on 2015/4/8.
 */
public class WhitelistPlayerResource extends ServerResource {
    private Logger logger;
    private IServer server;

    @Override
    public void doInit(){
        this.logger = ServerManager.getInstance().getServer().getLogger();
        this.server = ServerManager.getInstance().getServer();
    }

    @Post("json")
    public Representation acceptRepresentation(Representation entity){
        String userName = "";
        Boolean enable = false;
        try {
            JsonObject j = new JsonParser().parse(entity.getText()).getAsJsonObject();
            userName = j.get("userName").getAsString();
            enable = j.get("enable").getAsBoolean();
        }catch (Exception e){
            logger.info(e.toString());
            return new JacksonRepresentation<Result>(new Result("ERROR","JSONConvertError"));
        }
        logger.info("Whitelist user name: " + userName+" "+enable);
        server.setPlayerToWhiteList(userName, enable);
        logger.info("Whitelist: user: "+userName+" "+enable);
        return new JacksonRepresentation<Result>(new Result("OK"));
    }

    @Get("json")
    public Representation getRepresentation() {
        logger.info("GET WhiteList");
        Collection<? extends Player> players = server.getWhiteListPlayers();
        return new JacksonRepresentation< Collection<? extends Player> >(players);
    }
}
