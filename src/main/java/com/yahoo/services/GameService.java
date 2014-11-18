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


public class GameService extends BaseService
{
    



    private YQLQueryUtil yqlUitl ;

    protected GameService(YQLQueryUtil yqlUitl)
    {
        super(yqlUitl);
        this.yqlUitl = yqlUitl;
    }


    


    public List<GameWeek> retrieveGameWeeks()
    {

        List<GameWeek> result = null;
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> userData;
        Map<String, List<Map<String, Object>>> params;
        Map<String,Object> league;
        boolean morePlayers = true;
        int curr = 0;
        String response2 = yqlUitl.getConn().requestData("http://fantasysports.yahooapis.com/fantasy/v2/game/nfl/game_weeks?format=json", Verb.GET);
        try
        {
            userData = mapper.readValue(response2, Map.class);
            params = (Map<String, List<Map<String, Object>>>)userData.get("fantasy_content");
            Object game_weeks = ((Map<String, List<Map<String, Object>>>)params).get("game").get(1).get("game_weeks");
            int count = ((Integer)((Map<String, Object> )game_weeks).get("count"));
            int pos = 0;
            while (pos<count)
            {
                Map gameweek = ((Map<String, Map<String, Map>>)game_weeks).get(new Integer(pos).toString());
                GameWeek tempweek = mapper.readValue(JacksonPojoMapper.toJson(gameweek.get("game_week"), false) , GameWeek.class);
                if(result == null)
                {
                    result = new LinkedList<GameWeek>();
                }
                result.add(tempweek);
                pos++;
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    
}
