package com.yahoo.objects.league.transactions;

import com.yahoo.objects.league.LeagueMatchup;

import java.util.List;

/**
 * Created by cedric on 12/31/14.
 */
public class LeagueScoreboard
{
    private String week;
    private List<LeagueMatchup> matchups;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<LeagueMatchup> getMatchups() {
        return matchups;
    }

    public void setMatchups(List<LeagueMatchup> matchups) {
        this.matchups = matchups;
    }
}
