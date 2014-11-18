package com.yahoo.services;

import com.yahoo.objects.league.League;
import com.yahoo.objects.players.Player;
import com.yahoo.objects.team.Roster;
import com.yahoo.objects.team.RosterStats;
import com.yahoo.objects.team.Team;
import com.yahoo.objects.team.TeamStat;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.math.BigDecimal;
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

    protected TeamService(YQLQueryUtil yqlUitl) {
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

    public List<TeamStat> getWeeklyTeamPointsForSeason(String teamKey)
    {
        List<TeamStat> result = new LinkedList<TeamStat>();
        String yql = "select team_points,team_projected_points from fantasysports.teams.stats where team_key='"+teamKey+"' " +
                "and stats_type='week' and stats_week in('1', '2', '3','4','5','6','7','8','9','10','11','12','13','14','15','16','17')";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            List<Map<String, Object>> statList = (List<Map<String, Object>>) results.get("team"); //result details
            for (Map statMap : statList)
            {
                result.add(mapper.readValue(JacksonPojoMapper.toJson(statMap, false), TeamStat.class));
            }
        }
        catch(Exception e)
        {
            Logger.getLogger(TeamService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
    public List<RosterStats> getWeeklyTeamRosterPoints(String teamKey, int week)
    {
        List<RosterStats> result = new LinkedList<RosterStats>();
        String yql = "select * from fantasysports.teams.roster.stats where team_key='"+teamKey+"' and week = '"+week+"' ";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map<String, Object> teamMap = (Map<String, Object>) results.get("team"); //result details
            Map<String, Object> rosterMap = (Map<String, Object>) teamMap.get("roster"); //result details
            Map<String, Object> playersMap = (Map<String, Object>) rosterMap.get("players"); //result details
            List<Map<String, Object>> playersList = (List<Map<String, Object>>) playersMap.get("player");
            for (Map playerMap : playersList)
            {
                RosterStats temp = new RosterStats();
                temp.setPlayerKey((String) playerMap.get("player_key"));
                Map<String, String> selectedPositionMap = ((Map<String, String>)playerMap.get("selected_position"));
                temp.setSelectedPosition(selectedPositionMap.get("position"));
                Map<String, String> playerPointsMap = ((Map<String, String>)playerMap.get("player_points"));
                temp.setPlayerPoints(new BigDecimal(playerPointsMap.get("total")));
                result.add(temp);
            }
        }
        catch(Exception e)
        {
            Logger.getLogger(TeamService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
}
