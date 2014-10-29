package com.yahoo.objects.team;

/**
 * Created by cedric on 10/29/14.
 */
public class TeamStat
{
    private TeamPoints team_points;
    private TeamPoints team_projected_points;

    public TeamPoints getTeam_points()
    {
        return team_points;
    }

    public void setTeam_points(TeamPoints team_points)
    {
        this.team_points = team_points;
    }

    public TeamPoints getTeam_projected_points() {
        return team_projected_points;
    }

    public void setTeam_projected_points(TeamPoints team_projected_points) {
        this.team_projected_points = team_projected_points;
    }
}
