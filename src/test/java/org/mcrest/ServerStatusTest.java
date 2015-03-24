package org.mcrest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcrest.application.RestApplication;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;

/**
 * Created by frank on 2015/3/18.
 */
public class ServerStatusTest {
    private Client client;
    private Component component ;
    private String serverUrl;
    private int port = 8182;
    @Before
    public void setUp() {
        ServerManager.getInstance().setServer(new StubMCServer());
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
    public void TestGetServerStatus(){
        Request request = new Request(Method.GET, serverUrl+"/");
        Response response = client.handle(request);
        String responseString = response.getEntityAsText();
        Assert.assertTrue(responseString.contains("MCStub"));
    }
}

