/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.draft;

/**
 *
 * @author cedric
 */
public class DraftPick 
{
    String pick;
    String round;
    String player_key;
    String team_key;

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getPlayer_key() {
        return player_key;
    }

    public void setPlayer_key(String player_key) {
        this.player_key = player_key;
    }

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }
    
    
}
