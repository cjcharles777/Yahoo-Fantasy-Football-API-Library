package com.yahoo.services;

import com.yahoo.objects.league.League;
import com.yahoo.objects.players.Player;
import com.yahoo.objects.team.Roster;
import com.yahoo.objects.team.Team;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cedric on 10/8/14.
 */
public class TeamService extends BaseService
{

    public TeamService(YQLQueryUtil yqlUitl) {
        super(yqlUitl);
    }

    public Team getTeam (String teamKey)
    {

        Team result = null;
        String yql = "select * from fantasysports.teams where team_key='" + teamKey + "'";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map teamMap = (Map<String, Object>) results.get("team"); //result details
            result = mapper.readValue(JacksonPojoMapper.toJson(teamMap, false) , Team.class);
        }
        catch(Exception e)
        {
            Logger.getLogger(TeamService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
    public List<Team> getLeagueTeams (String leagueKey)
    {

        List<Team> result = new LinkedList<Team>();
        String yql = "select * from fantasysports.teams where league_key='" + leagueKey + "'";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            List<Map<String, Object>> teamList = (List<Map<String, Object>>) results.get("team"); //result details
            for (Map teamMap : teamList)
            {
                result.add(mapper.readValue(JacksonPojoMapper.toJson(teamMap, false), Team.class));
            }
        }
        catch(Exception e)
        {
            Logger.getLogger(TeamService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
    public Roster getTeamRoster (String teamKey)
    {

        Roster result = null;
        String yql = "select * from fantasysports.teams.roster where team_key='" + teamKey + "'";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map<String, Object> teamResultMap = (Map<String, Object>) results.get("team"); //result details
            Map<String, Object> rosterMap = (Map<String, Object>) teamResultMap.get("roster");
            return mapper.readValue(JacksonPojoMapper.toJson(rosterMap, false), Roster.class);
        }
        catch(Exception e)
        {
            Logger.getLogger(TeamService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
}
