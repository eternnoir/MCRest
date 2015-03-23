package org.mcrest.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class define Auth paras.
 * Created by frank on 2015/3/23.
 */
public class AuthPara {
    private String userId;
    private String password;
    private Map<String,Boolean> protectedResources;

    public AuthPara(String userId,String password){
        this.init(userId,password,new ArrayList<String>());
    }

    public AuthPara(String userId,String password,Collection<String> protectedResources){
        this.init(userId,password,protectedResources);
    }

    private void init(String userId,String password,Collection<String> protectedResourceList){
        this.userId = userId;
        this.password = password;
        this.protectedResources = new HashMap<String, Boolean>();
        for(String res : protectedResourceList){
            if(!this.protectedResources.containsKey(res)){
                this.protectedResources.put(res,true) ;
            }
        }
    }

    public void addProtectResource(String resource){
        if(!this.protectedResources.containsKey(resource)){
            this.protectedResources.put(resource,true);
        }
    }

    public boolean isProtected(String resource){
        boolean isProtected = false;
        if(this.protectedResources.containsKey(resource)){
            isProtected = this.protectedResources.get(resource);
        }
        return isProtected;
    }

    public Map<String,Boolean> getProtectedResourceMap(){
        return this.protectedResources;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
