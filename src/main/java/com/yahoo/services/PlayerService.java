package com.yahoo.services;

import com.yahoo.objects.players.Player;
import com.yahoo.objects.stats.SeasonStat;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cedric on 10/13/14.
 */
public class PlayerService extends BaseService
{
    protected PlayerService(YQLQueryUtil yqlUitl) {
        super(yqlUitl);
    }

    public Player getPlayer (String playerKey)
    {

        Player result = null;
        String yql = "select * from fantasysports.players where player_key='" + playerKey + "'";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map<String, Object> playerResultMap = (Map<String, Object>) results.get("player"); //result details
            return mapper.readValue(JacksonPojoMapper.toJson(playerResultMap, false), Player.class);
        }
        catch(Exception e)
        {
            Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }
    public SeasonStat getPlayerSeasonStats (String playerKey, String leagueKey)
    {

        SeasonStat result = null;
        String yql = "select * from fantasysports.players.stats where player_key='" + playerKey + "' and league_key='"+ leagueKey +"'";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String, Object> results = performYQLQuery(yql); //result details
            Map<String, Object> playerResultMap = (Map<String, Object>) results.get("player"); //result details
            Map<String, Object> playerStatResultMap = (Map<String, Object>) playerResultMap.get("player_stats"); //result details
            return mapper.readValue(JacksonPojoMapper.toJson(playerStatResultMap, false), SeasonStat.class);
        }
        catch(Exception e)
        {
            Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }


}
