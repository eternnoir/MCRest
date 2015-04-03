package org.mcrest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcrest.application.RestApplication;
import org.mcrest.entity.Message;
import org.mcrest.entity.Player;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;

/**
 * Created by frank on 2015/4/3.
 */
public class ChatResourceTest {
    private Client client;
    private Component component ;
    private String serverUrl;
    private int port = 8182;
    private StubMCServer stubMCServer;
    @Before
    public void setUp() {
        this.stubMCServer = new StubMCServer();
        ServerManager.getInstance().setServer(this.stubMCServer);
        component = new Component();
        client =  new Client(Protocol.HTTP);
        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, port);
        // Attach the sample application.
        component.getDefaultHost().attach("/mcrest", new RestApplication());
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        serverUrl = "http://127.0.0.1:"+port+"/mcrest";
    }

    @After
    public void tearDown() {
        try {
            component.stop();
            component = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDefaultMessageSize(){
        int numOfmsg=10;
        for(int i=0;i<numOfmsg;i++){
            stubMCServer.getMessageList().add(new Message(new Player(),""+i));
        }
        Request request = new Request(Method.GET, serverUrl+"/chat");
        Response response = client.handle(request);
        String responseString = response.getEntityAsText();
        JSONArray jobjs =null;
        try {
            jobjs = new JSONArray(responseString);
        } catch (JSONException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(jobjs.length(),numOfmsg);
    }

    @Test
    public void testGetSpecMessageSize(){
        int numOfmsg=1000;
        for(int i=0;i<numOfmsg;i++){
            stubMCServer.getMessageList().add(new Message(new Player(),""+i));
        }
        int getNum = 10;
        Request request = new Request(Method.GET, serverUrl+"/chat/"+getNum);
        Response response = client.handle(request);
        String responseString = response.getEntityAsText();
        JSONArray jobjs =null;
        try {
            jobjs = new JSONArray(responseString);
        } catch (JSONException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(jobjs.length(),getNum);
    }


    @Test
    public void testGetOverMessageSize(){
        int numOfmsg=3;
        for(int i=0;i<numOfmsg;i++){
            stubMCServer.getMessageList().add(new Message(new Player(),""+i));
        }
        int getNum = 10;
        Request request = new Request(Method.GET, serverUrl+"/chat/"+getNum);
        Response response = client.handle(request);
        String responseString = response.getEntityAsText();
        JSONArray jobjs =null;
        try {
            jobjs = new JSONArray(responseString);
        } catch (JSONException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(jobjs.length(),numOfmsg);
    }

}
