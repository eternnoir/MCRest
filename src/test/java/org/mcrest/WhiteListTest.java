package org.mcrest;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcrest.application.RestApplication;
import org.mcrest.server.IServer;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

/**
 * Created by frank on 2015/3/24.
 */
public class WhiteListTest {
    private Client client;
    private Component component ;
    private String serverUrl;
    private int port = 8185;
    private IServer stubServer;
    @Before
    public void setUp() {
        stubServer = new StubMCServer();
        ServerManager.getInstance().setServer(stubServer);
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
        client =  new Client(Protocol.HTTP);
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
    public void testEnableWhiteList(){
        ClientResource cr = new ClientResource(serverUrl+"/whitelist/enable");
        JSONObject jo = new JSONObject();
        try {
            jo.put("enable", true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        cr.post(jo,MediaType.APPLICATION_JSON);
        if (!cr.getStatus().isSuccess()) {
            Assert.fail();
        }
        Assert.assertTrue(stubServer.hasWhiteList());
    }

    @Test
    public void testDisableWhiteList(){
        ClientResource cr = new ClientResource(serverUrl+"/whitelist/enable");
        JSONObject jo = new JSONObject();
        try {
            jo.put("enable", false);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        cr.post(jo,MediaType.APPLICATION_JSON);
        if (!cr.getStatus().isSuccess()) {
            Assert.fail();
        }
        Assert.assertFalse(stubServer.hasWhiteList());
    }



}
