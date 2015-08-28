package com.yahoo.services;

import com.google.gson.*;
import com.yahoo.objects.players.Player;
import com.yahoo.objects.stats.SeasonStat;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.LinkedList;
import java.util.List;
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

    public List<Player> retriveLeaugePlayers(String leagueid) {
        Gson gson = new GsonBuilder().create();

        JsonObject userData;
        JsonObject results;
        JsonArray playerList;
        JsonObject query;
        int start = 0;
        boolean morePlayers = true;
        List<Player> leaguePlayerResults = new LinkedList<Player>();

        while (morePlayers) {
            String yql = "select * from fantasysports.players where league_key='" + leagueid + "' and start=" + start;
            String response = performYQLQueryString(yql);// yqlUitl.queryYQL(yql);
            try {
                userData = gson.fromJson(response, JsonObject.class).getAsJsonObject();
                query = userData.get("query").getAsJsonObject(); // query details
                int count = query.get("count").getAsInt();
                results = query.get("results").getAsJsonObject(); //result details
                playerList = (JsonArray) results.get("player"); //result details
                for (JsonElement leauge : playerList) {
                    Player tempLeauge = gson.fromJson(leauge, Player.class);
                    leaguePlayerResults.add(tempLeauge);
                }
                start += count;
                Logger.getLogger(PlayerService.class.getName()).log(Level.INFO, "Start Count : " + start);
                if (count < 25) {
                    morePlayers = false;
                }

            } catch (Exception e) {
                Logger.getLogger(PlayerService.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return leaguePlayerResults;
    }
}
