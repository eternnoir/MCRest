package org.mcrest.entity;

import java.io.Serializable;

/**
 * Player class is model in minecraft game. It has some attribute for Rest Ues.
 *
 * Created by frank on 2015/3/3.
 */
public class Player implements Serializable {
    private String displayName;

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
