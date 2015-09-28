package com.yahoo.objects.league;

import com.yahoo.objects.team.Team;
import com.yahoo.objects.team.TeamList;

import java.util.List;

/**
 * Created by cedric on 12/31/14.
 */
public class LeagueMatchup
{
    private String week;
    private String week_start;
    private String week_end;
    private String status;
    private String is_playoffs;
    private String is_consolation;
    private String is_tied;
    private String winner_team_key;
    private TeamList teams;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeek_start() {
        return week_start;
    }

    public void setWeek_start(String week_start) {
        this.week_start = week_start;
    }

    public String getWeek_end() {
        return week_end;
    }

    public void setWeek_end(String week_end) {
        this.week_end = week_end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_playoffs() {
        return is_playoffs;
    }

    public void setIs_playoffs(String is_playoffs) {
        this.is_playoffs = is_playoffs;
    }

    public String getIs_consolation() {
        return is_consolation;
    }

    public void setIs_consolation(String is_consolation) {
        this.is_consolation = is_consolation;
    }

    public String getIs_tied() {
        return is_tied;
    }

    public void setIs_tied(String is_tied) {
        this.is_tied = is_tied;
    }

    public String getWinner_team_key() {
        return winner_team_key;
    }

    public void setWinner_team_key(String winner_team_key) {
        this.winner_team_key = winner_team_key;
    }

    public TeamList getTeams() {
        return teams;
    }

    public void setTeams(TeamList teams) {
        this.teams = teams;
    }
}
