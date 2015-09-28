package com.yahoo.objects.league.transactions;

import com.yahoo.objects.league.LeagueMatchup;
import com.yahoo.objects.league.LeagueMatchupList;

import java.util.List;

/**
 * Created by cedric on 12/31/14.
 */
public class LeagueScoreboard
{ //TODO: Yahoo has overhauled this object and the structure has changed follow permalink http://www.jsonmate.com/permalink/560826a29ac68be5660e7242
    private String week;
    private LeagueMatchupList matchups;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public LeagueMatchupList getMatchups() {
        return matchups;
    }

    public void setMatchups(LeagueMatchupList matchups) {
        this.matchups = matchups;
    }
}
