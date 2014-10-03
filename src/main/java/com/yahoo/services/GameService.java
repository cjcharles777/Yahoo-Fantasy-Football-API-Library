/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.services;


import com.yahoo.objects.draft.DraftResults;
import com.yahoo.objects.league.League;
import com.yahoo.objects.league.LeagueSettings;
import com.yahoo.objects.stats.GameWeek;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.oauth.OAuthConnection;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.model.Verb;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */


public class GameService 
{
    



    private YQLQueryUtil yqlUitl ;

    public GameService(YQLQueryUtil yqlUitl) {

        this.yqlUitl = yqlUitl;
    }

    public List<League> getUserLeagues(String gameKey)
    {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> userData;
            Map<String,Object> results;
            List<Map<String, Object>> leaugeList;
            Map<String,Object> query;
            List<League> leagueListResults = new LinkedList<League>();
            String ql = "select * from fantasysports.leagues where game_key = '"+ gameKey+"' and use_login=1";
            String response = yqlUitl.queryYQL(ql);
               try
               {
                   userData = mapper.readValue(response, Map.class);
                   query = (Map<String, Object>)userData.get("query"); // query details
                   results = (Map<String, Object>)query.get("results"); //result details
                   leaugeList = (List<Map<String, Object>>)results.get("league"); //result details
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
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> userData;
            Map<String,Object> results;
            List<Map<String, Object>> leaugeList;
            Map<String,Object> query;
        League  leagueListResults = new League();
            String yql = "select * from fantasysports.leagues where league_key='"+leagueid+"'";
            String response = yqlUitl.queryYQL(yql);
            try
            {
                userData = mapper.readValue(response, Map.class);
                query = (Map<String, Object>)userData.get("query"); // query details
                results = (Map<String, Object>)query.get("results"); //result details
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
    public LeagueSettings getLeagueSettings (String leagueid)
    {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> userData;
            Map<String,Object> results;
            List<Map<String, Object>> leaugeList;
            Map<String,Object> query;
            LeagueSettings leagueListResults = new LeagueSettings();
            String yql = "select * from fantasysports.leagues.settings where league_key='"+leagueid+"'";
            String response = yqlUitl.queryYQL(yql);
            try
            {
                userData = mapper.readValue(response, Map.class);
                query = (Map<String, Object>)userData.get("query"); // query details
                results = (Map<String, Object>)query.get("results"); //result details
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
    
    public DraftResults getDraftResults (String leagueid)
    {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> userData;
            Map<String,Object> results;
            List<Map<String, Object>> draftList;
            Map<String,Object> query;
            DraftResults  leagueListResults = new DraftResults();
            String yql = "select * from fantasysports.draftresults where league_key='"+leagueid+"'";
            String response = yqlUitl.queryYQL(yql);
            try
            {
                userData = mapper.readValue(response, Map.class);
                query = (Map<String, Object>)userData.get("query"); // query details
                results = (Map<String, Object>)query.get("results"); //result details
                Map leauge = (Map<String, Object>)results.get("league"); //result details
                Map map = (Map<String, Object>)leauge.get("draft_results"); //result details
                DraftResults tempLeauge = mapper.readValue(JacksonPojoMapper.toJson(map, false) , DraftResults.class);
                leagueListResults = tempLeauge;

                
               
            }
            catch(Exception e)
            {
                 Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, e);
            }
             
             return leagueListResults;
    }

    
}
