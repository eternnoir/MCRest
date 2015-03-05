package org.mcrest;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by frank on 2015/3/5.
 */
public class ConfigHandler {
    private static ConfigHandler instance = null;
    private JavaPlugin plugin;
    private int port=8281;
    private String prefix="mcrest";
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

    public void setConfigByPlugin(JavaPlugin bukkitplugin){
        this.plugin= bukkitplugin;
        if(!plugin.getConfig().contains("port")){
            plugin.getLogger().info("Set Port to 8281");
            setPort(8281);
        }else {
            setPort(plugin.getConfig().getInt("port"));
        }
        if(!plugin.getConfig().contains("prefix")){
            setPrefix("mcrest");
        }else {
            setPrefix(plugin.getConfig().getString("prefix"));
        }
    }

    public void setPort(int port) {
        plugin.getConfig().set("port", port);
        this.port = port;
        plugin.saveConfig();
    }

    public int getPort() {
        return port;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        plugin.getConfig().set("prefix",prefix);
        this.prefix = prefix;
        plugin.saveConfig();
    }

    public void saveConfig(){
        this.plugin.saveConfig();
    }
}
