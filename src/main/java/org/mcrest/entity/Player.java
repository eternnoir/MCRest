package org.mcrest.entity;

import java.io.Serializable;

/**
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
