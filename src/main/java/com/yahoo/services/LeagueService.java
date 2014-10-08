package com.yahoo.services;

import com.yahoo.exceptions.BadQueryException;
import com.yahoo.objects.league.League;
import com.yahoo.objects.league.LeagueSettings;
import com.yahoo.objects.team.TeamStandings;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cedric on 10/8/14.
 */
public class LeagueService extends BaseService
{

    public LeagueService(YQLQueryUtil yqlUitl)
    {
        super(yqlUitl);
    }

    public List<League> getUserLeagues(String gameKey)
    {

        List<League> leagueListResults = new LinkedList<League>();
        String ql = "select * from fantasysports.leagues where game_key = '"+ gameKey+"' and use_login=1";

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> results = performYQLQuery(ql); //result details
            List<Map<String, Object>> leaugeList = (List<Map<String, Object>>)results.get("league"); //result details
            for (Map map : leaugeList)
            {
                League tempLeauge = mapper.readValue(JacksonPojoMapper.toJson(map, false) , League.class);
                leagueListResults.add(tempLeauge);
            }


        }
        catch(Exception e)
        {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, e);
        }
        return leagueListResults;

    }

    public League getLeague (String leagueid)
    {

        League  leagueListResults = new League();
        String yql = "select * from fantasysports.leagues where league_key='"+leagueid+"'";

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> results = performYQLQuery(yql); //result details
            Map map = (Map<String, Object>)results.get("league"); //result details
            League tempLeauge = mapper.readValue(JacksonPojoMapper.toJson(map, false) , League.class);
            leagueListResults = tempLeauge;



        }
        catch(Exception e)
        {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, e);
        }

        return leagueListResults;
    }

    public LeagueSettings getLeagueSettings (String leagueId)
    {

        LeagueSettings leagueListResults = new LeagueSettings();
        String yql = "select * from fantasysports.leagues.settings where league_key='"+leagueId+"'";

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> results = performYQLQuery(yql); //result details
            Map leaugeMap = (Map<String, Object>)results.get("league"); //result details
            Map resultMap = (Map<String, Object>)leaugeMap.get("settings"); //result details
            LeagueSettings tempLeauge = mapper.readValue(JacksonPojoMapper.toJson(resultMap, false) , LeagueSettings.class);
            leagueListResults = tempLeauge;



        }
        catch(Exception e)
        {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, e);
        }

        return leagueListResults;
    }

    public Map<String, TeamStandings> getLeagueStandings(String leagueId)
    {
        String yql = "select * from fantasysports.leagues.standings where league_key='"+leagueId+"'";
        Map<String,TeamStandings> result = new HashMap<String, TeamStandings>();
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map leagueMap = (Map<String, Object>)results.get("league"); //result details
            Map standingsMap = (Map<String, Object>)leagueMap.get("standings"); //standings yahoo object
            Map teamsMap = (Map<String, Object>)standingsMap.get("teams"); //teams yahoo Object
            List<Map<String, Object>> teamList = (List<Map<String, Object>>)teamsMap.get("team"); // teams yahoo list
            for(Map<String, Object> team : teamList)
            {
                String teamKey = ((String)team.get("team_key"));
                Map resultMap = (Map<String, Object>) team.get("team_standings");
                TeamStandings standings = mapper.readValue(JacksonPojoMapper.toJson(resultMap, false), TeamStandings.class);
                result.put(teamKey, standings);
            }
            //return result;
        }
        catch(Exception e)
        {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }


}
