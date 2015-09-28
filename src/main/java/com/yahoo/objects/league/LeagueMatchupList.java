package com.yahoo.objects.league;

import java.util.List;

/**
 * Created by cedric on 9/27/15.
 */
public class LeagueMatchupList
{
    private List<LeagueMatchup> matchup;
    private String count;

    public List<LeagueMatchup> getMatchup() {
        return matchup;
    }

    public void setMatchup(List<LeagueMatchup> matchup) {
        this.matchup = matchup;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
