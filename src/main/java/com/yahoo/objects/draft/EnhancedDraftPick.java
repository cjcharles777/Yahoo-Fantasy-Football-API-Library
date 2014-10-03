/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.draft;


import com.yahoo.objects.players.Player;
import com.yahoo.objects.team.Team;

/**
 *
 * @author cedric
 */
public class EnhancedDraftPick 
{
    private int pick;
    private Player player;
    private Team team;
    private int round;

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    
    
    
    
    
}
