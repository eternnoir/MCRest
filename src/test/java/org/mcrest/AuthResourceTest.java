package org.mcrest;


import com.sun.jna.platform.win32.Winspool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcrest.application.RestApplication;
import org.mcrest.utils.AuthPara;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;

import java.util.ArrayList;

/**
 * Created by frank on 2015/3/24.
 */
public class AuthResourceTest {
    private String serverUrl;
    private int port = 8183;
    private Component component ;
    @Before
    public void setUp() {
        serverUrl = "http://127.0.0.1:"+port+"/mcrest";
        ServerManager.getInstance().setServer(new StubMCServer());
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
    public void authDisableTest(){
        AuthPara auth = new AuthPara("test","test",false);
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, port);
        component.getDefaultHost().attach("/mcrest", new RestApplication(auth));
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        String responseString = getRequestResult("/").getEntityAsText();
        Assert.assertTrue(responseString.contains("MCStub"));
        String worldResult = getRequestResult("/world").getEntityAsText();
        Assert.assertTrue(worldResult.contains("testWorld"));
    }

    @Test
    public void authEnableAllResource(){
        AuthPara auth = new AuthPara("test","test",genAllResoureceList(),true);
        component = new Component();
        component.getServers().add(Protocol.HTTP, port);
        component.getDefaultHost().attach("/mcrest", new RestApplication(auth));
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        int statusCode = getRequestResult("/").getStatus().getCode();
        Assert.assertEquals(statusCode, 401);
        statusCode = getRequestResult("/player").getStatus().getCode();
        Assert.assertEquals(statusCode, 401);
        statusCode = getRequestResult("/world").getStatus().getCode();
        Assert.assertEquals(statusCode, 401);
    }

    private Response getRequestResult(String path) {
        Client client =  new Client(Protocol.HTTP);
        Request request = new Request(Method.GET, serverUrl+path);
        Response response = client.handle(request);
        String s = response.getEntityAsText();
        return response;
    }

    private ArrayList<String> genAllResoureceList(){
        ArrayList<String> resourceList = new ArrayList<String>();
        resourceList.add("/");
        resourceList.add("/player");
        resourceList.add("/world");
        return resourceList;
    }
}
