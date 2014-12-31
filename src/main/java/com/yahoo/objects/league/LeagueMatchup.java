package com.yahoo.objects.league;

import java.util.List;

/**
 * Created by cedric on 12/31/14.
 */
public class LeagueMatchup
{
    private String winnerTeamKey;
    private List<LeagueMatchupTeam> teams;

    public String getWinnerTeamKey() {
        return winnerTeamKey;
    }

    public void setWinnerTeamKey(String winnerTeamKey) {
        this.winnerTeamKey = winnerTeamKey;
    }

    public List<LeagueMatchupTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<LeagueMatchupTeam> teams) {
        this.teams = teams;
    }
}
