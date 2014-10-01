/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.team;

import com.yahoo.objects.players.Player;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 *
 * @author cedric
 */
@JsonIgnoreProperties({"count"})
public class RosterPlayers 
{
    
    private String count;
    private List<Player> player;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Player> getPlayers() {
        return player;
    }

    public void setPlayers(List<Player> players) {
        this.player = players;
    }
    
    
}
