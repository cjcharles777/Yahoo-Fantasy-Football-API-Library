package com.yahoo.objects.league;

import com.yahoo.objects.team.TeamPoints;

/**
 * Created by cedric on 12/31/14.
 */
public class LeagueMatchupTeam
{
    private String teamKey;
    private TeamPoints teamPoints;
    private TeamPoints teamProjectedPoints;

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public TeamPoints getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(TeamPoints teamPoints) {
        this.teamPoints = teamPoints;
    }

    public TeamPoints getTeamProjectedPoints() {
        return teamProjectedPoints;
    }

    public void setTeamProjectedPoints(TeamPoints teamProjectedPoints) {
        this.teamProjectedPoints = teamProjectedPoints;
    }
}
