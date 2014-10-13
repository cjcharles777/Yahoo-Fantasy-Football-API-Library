/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.team;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author cedric
 */
@JsonIgnoreProperties({"coverage_type"})
public class Roster 
{
    private String coverage_type;
    private String week;
    private String is_editable;
    private WeekRosterPlayers players;

    public String getCoverage_type() {
        return coverage_type;
    }

    public void setCoverage_type(String coverage_type) {
        this.coverage_type = coverage_type;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public WeekRosterPlayers getPlayers() {
        return players;
    }

    public void setPlayers(WeekRosterPlayers players) {
        this.players = players;
    }

    public String getIs_editable() {
        return is_editable;
    }

    public void setIs_editable(String is_editable) {
        this.is_editable = is_editable;
    }
}
