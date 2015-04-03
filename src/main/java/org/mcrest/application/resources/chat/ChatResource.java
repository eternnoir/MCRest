package org.mcrest.application.resources.chat;

import org.mcrest.ServerManager;
import org.mcrest.entity.Message;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by frank on 2015/4/3.
 */
public class ChatResource extends ServerResource{
    private Logger logger;
    private Integer numberOfMessage = null;
    private int defaultMsgNum = 100;
    @Override
    public void doInit() {
        logger = ServerManager.getInstance().getServer().getLogger();
        String numStr = getAttribute("num");
        this.numberOfMessage = defaultMsgNum;
        if(isInteger(numStr)){
            int messageNum = Integer.parseInt(numStr);
            if(messageNum>0){
                this.numberOfMessage = Integer.parseInt(numStr);
            }
        }
    }


    @Get("json")
    public Representation getRepresentation() {
        List<Message> messages =
                ServerManager.getInstance().getServer().getMessages(this.numberOfMessage);
        this.logger.info("GET Messages:"+this.numberOfMessage);
        return new JacksonRepresentation<List<Message>>(messages);
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
