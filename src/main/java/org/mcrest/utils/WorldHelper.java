package org.mcrest.utils;

import org.mcrest.entity.World;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by frank on 2015/3/13.
 */
public class WorldHelper {
    public static Collection<? extends World> ConvertBukkitWorldToRest(Collection<? extends org.bukkit.World>  bWorlds){
        ArrayList<World> worlds = new ArrayList<World>();
        for(org.bukkit.World bw : bWorlds){
            World rw = new World(bw);
            worlds.add(rw);
        }
        return worlds;
    }
}
