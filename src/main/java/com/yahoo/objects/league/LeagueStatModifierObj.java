/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.league;

/**
 *
 * @author cedric
 */
public class LeagueStatModifierObj
{
    public String stat_id;
    public String value;
    public LeagueStatModifierBonusList bonuses;

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LeagueStatModifierBonusList getBonuses() {
        return bonuses;
    }

    public void setBonuses(LeagueStatModifierBonusList bonuses) {
        this.bonuses = bonuses;
    }
    
    
}
