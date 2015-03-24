package org.mcrest.entity;

import java.util.Collection;

/**
 * Created by frank on 2015/3/24.
 */
public class WhiteList {
    private Boolean enabled;
    private Collection<? extends Player> whiteListPlayers;
    public WhiteList(Boolean enabled,Collection<? extends Player> whiteListPlayers){
        this.enabled = enabled;
        this.whiteListPlayers=whiteListPlayers;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Collection<? extends Player> getWhiteListPlayers() {
        return whiteListPlayers;
    }
}
