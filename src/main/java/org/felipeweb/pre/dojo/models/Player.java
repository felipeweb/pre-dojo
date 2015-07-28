package org.felipeweb.pre.dojo.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by felipeweb on 7/27/15.
 */
public class Player {
    private String name;
    private Integer kills = 0;
    private Integer dies = 0;

    public void killsUp() {
        kills++;
    }

    public void diesUp() {
        dies++;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDies() {
        return dies;
    }

    public void setDies(Integer dies) {
        this.dies = dies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
