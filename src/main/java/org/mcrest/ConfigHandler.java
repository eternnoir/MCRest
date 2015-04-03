package org.mcrest;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcrest.utils.AuthPara;

import java.util.ArrayList;

/**
 * This is mcrest config handler. All mcrest needed config para are store here.
 * Created by frank on 2015/3/5.
 */
public class ConfigHandler {
    private static ConfigHandler instance = null;
    private JavaPlugin plugin;
    private int port = 8281;
    private String prefix = "mcrest";
    private AuthPara authPara = null;

    protected ConfigHandler() {
    }

    public static ConfigHandler getInstance() {
        if (instance == null) {
            synchronized (ConfigHandler.class) {
                if (instance == null) {
                    instance = new ConfigHandler();
                }
            }
        }
        return instance;
    }

    /**
     * Set Config value by bukkit plugin.
     *
     * @param bukkitplugin
     */
    public void setConfigByPlugin(JavaPlugin bukkitplugin) {
        this.plugin = bukkitplugin;
        initPort();
        initPrefix();
        initAuthPara();
    }

    private void initPrefix() {
        if (!plugin.getConfig().contains("prefix")) {
            setPrefix("mcrest");
        } else {
            setPrefix(plugin.getConfig().getString("prefix"));
        }
    }

    /**
     * Init port setting. The default port is 8281.
     */
    private void initPort() {
        if (!plugin.getConfig().contains("port")) {
            plugin.getLogger().info("Set Port to 8281");
            setPort(8281);
        } else {
            setPort(plugin.getConfig().getInt("port"));
        }
    }

    /**
     * Set up authParaObject. If has config file , it will ues config file.
     * If not use default.
     */
    private void initAuthPara() {

        if (!plugin.getConfig().contains("auth.enable")) {
            setAuth(false, "mcrest", "mcrest", genDefaultResourceList());
        }
        String userId = plugin.getConfig().getString("auth.user");
        String password = plugin.getConfig().getString("auth.password");
        Boolean enabled = plugin.getConfig().getBoolean("auth.enable");
        ArrayList<String> resourceList = new ArrayList(plugin.getConfig().getList("auth.protected"));
        authPara = new AuthPara(userId, password, resourceList, enabled);
    }

    private ArrayList<String> genDefaultResourceList() {
        ArrayList<String> resourceList = new ArrayList<String>();
        resourceList.add("/");
        resourceList.add("/player");
        resourceList.add("/world");
        resourceList.add("/whitelist");
        resourceList.add("/chat");
        return resourceList;
    }

    public int getPort() {
        return port;
    }

    /**
     * Set mcrest listen port.
     *
     * @param port
     */
    public void setPort(int port) {
        synchronized (this) {
            plugin.getConfig().set("port", port);
            this.port = port;
            plugin.saveConfig();
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        synchronized (this) {
            plugin.getConfig().set("prefix", prefix);
            this.prefix = prefix;
            plugin.saveConfig();
        }
    }

    public void setAuth(Boolean enable, String user, String password, ArrayList<String> resources) {
        synchronized (this) {
            plugin.getConfig().set("auth.enable", false);
            plugin.getConfig().set("auth.user", user);
            plugin.getConfig().set("auth.password", password);
            plugin.getConfig().set("auth.protected", resources);
            this.saveConfig();
        }
    }

    public void saveConfig() {
        this.plugin.saveConfig();
    }

    public AuthPara getAuthPara() {
        return authPara;
    }


}
