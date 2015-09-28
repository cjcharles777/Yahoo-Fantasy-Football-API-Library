package com.yahoo.objects.team;

import java.util.List;

/**
 * Created by cedric on 9/27/15.
 */
public class TeamList
{
    private List<Team> team;
    private String count;

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
