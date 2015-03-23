package org.mcrest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcrest.utils.AuthPara;

import java.util.ArrayList;

/**
 * Created by frank on 2015/3/23.
 */
public class AuthParaTest {
    @Test
    public void TestCreateAuthPara(){
        String userId = "user";
        String passwd = "pass";
        AuthPara authp = new AuthPara(userId,passwd);
        Assert.assertEquals(authp.getUserId(),userId);
        Assert.assertEquals(authp.getPassword(),passwd);
    }

    @Test
    public void TestAuthParaDefaultResSize(){
        String userId = "user";
        String passwd = "pass";
        AuthPara authp = new AuthPara(userId,passwd);
        Assert.assertEquals(authp.getProtectedResourceMap().values().size(),0);
    }

    @Test
    public void TestWithDeafultResource(){
        String userId = "user";
        String passwd = "pass";
        ArrayList<String> defaultRes = new ArrayList<String>();
        defaultRes.add("A");
        defaultRes.add("B");
        AuthPara authp = new AuthPara(userId,passwd,defaultRes);
        Assert.assertEquals(authp.getProtectedResourceMap().size(),2);
    }


    @Test
    public void TestWithDeafultResourceDup(){
        String userId = "user";
        String passwd = "pass";
        ArrayList<String> defaultRes = new ArrayList<String>();
        defaultRes.add("A");
        defaultRes.add("B");
        defaultRes.add("B");
        AuthPara authp = new AuthPara(userId,passwd,defaultRes);
        Assert.assertEquals(authp.getProtectedResourceMap().size(),2);
    }

    @Test
    public void TestAddProtectedResource(){
        String userId = "user";
        String passwd = "pass";
        AuthPara authp = new AuthPara(userId,passwd);
        authp.addProtectResource("A");
        authp.addProtectResource("B");
        Assert.assertEquals(authp.getProtectedResourceMap().values().size(),2);
    }


    @Test
    public void TestAddProtectedResourceDup(){
        String userId = "user";
        String passwd = "pass";
        AuthPara authp = new AuthPara(userId,passwd);
        authp.addProtectResource("A");
        authp.addProtectResource("A");
        Assert.assertEquals(authp.getProtectedResourceMap().values().size(),1);
    }

    @Test
    public void TestCheckResourceAdded(){
         String userId = "user";
        String passwd = "pass";
        ArrayList<String> defaultRes = new ArrayList<String>();
        defaultRes.add("A");
        defaultRes.add("B");
        defaultRes.add("C");
        AuthPara authp = new AuthPara(userId,passwd,defaultRes);
        Assert.assertEquals(authp.isProtected("A"),true);
        Assert.assertEquals(authp.isProtected("B"),true);
        Assert.assertEquals(authp.isProtected("C"),true);
    }

    @Test
    public void TestCheckResourceNotAdded(){
         String userId = "user";
        String passwd = "pass";
        ArrayList<String> defaultRes = new ArrayList<String>();
        defaultRes.add("A");
        defaultRes.add("B");
        AuthPara authp = new AuthPara(userId,passwd,defaultRes);
        Assert.assertEquals(authp.isProtected("A"),true);
        Assert.assertEquals(authp.isProtected("B"),true);
        Assert.assertEquals(authp.isProtected("C"),false);
    }
}
