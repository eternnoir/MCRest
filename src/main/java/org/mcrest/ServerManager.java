package org.mcrest;

import org.mcrest.server.IServer;

/**
 * Created by frank on 2015/3/3.
 */
public class ServerManager {
    private static ServerManager instance = null;
    private IServer server = null;

    protected ServerManager() {
    }
    public static ServerManager getInstance() {
        if (instance == null) {
            synchronized (ServerManager.class) {
                if (instance == null) {
                    instance = new ServerManager();
                }
            }
        }
        return instance;
    }

    /**
     * Server Setter.
     * @param server
     */
    public void setServer(IServer server){
        synchronized (ServerManager.class) {
            this.server = server;
        }
    }

    /**
     * Server Getter.
     * @return
     */
    public IServer getServer() {
        return server;
    }
}
