package org.mcrest;


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

/**
 * Created by frank on 2015/3/24.
 */
public class AuthResourceTest {
    private String serverUrl;
    private int port = 8183;
    @Before
    public void setUp() {
        serverUrl = "http://127.0.0.1:"+port+"/mcrest";
        ServerManager.getInstance().setServer(new StubMCServer());
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
        String responseString = getRequestResult("/");
        Assert.assertTrue(responseString.contains("MCStub"));
        String worldResult = getRequestResult("/world");
        Assert.assertTrue(worldResult.contains("testWorld"));
    }

    private String getRequestResult(String path) {
        Client client =  new Client(Protocol.HTTP);
        Request request = new Request(Method.GET, serverUrl+path);
        Response response = client.handle(request);
        return response.getEntityAsText();
    }
}
