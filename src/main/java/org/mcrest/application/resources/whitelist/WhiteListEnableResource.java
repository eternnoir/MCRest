package org.mcrest.application.resources.whitelist;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.mcrest.ServerManager;
import org.mcrest.application.resources.Result;
import org.mcrest.server.IServer;
import org.restlet.data.Form;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

import static org.mcrest.ServerManager.*;

/**
 * Created by frank on 2015/3/24.
 */
public class WhiteListEnableResource  extends ServerResource {
    private Logger logger;
    private IServer server;

    @Override
    public void doInit(){
        this.logger = getInstance().getServer().getLogger();
        this.server = getInstance().getServer();
    }

    @Post("json")
    public Representation acceptRepresentation(Representation entity){
        Boolean enabled = false;
        try {
            JsonObject j = new JsonParser().parse(entity.getText()).getAsJsonObject();
            enabled = j.get("enable").getAsBoolean();
        }catch (Exception e){
            logger.info(e.toString());
            return new JacksonRepresentation<Result>(new Result("ERROR","JSONConvertError"));
        }
        logger.info("Whitelist post "+enabled);
        server.setWhiteList(enabled);
        logger.info("Whitelist: Set whiteList to "+enabled);
        return new JacksonRepresentation<Result>(new Result("OK"));
    }
}
