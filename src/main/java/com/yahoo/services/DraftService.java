package com.yahoo.services;

import com.yahoo.objects.draft.DraftResults;
import com.yahoo.utils.json.JacksonPojoMapper;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cedric on 10/29/14.
 */
public class DraftService  extends BaseService
{
    public DraftService(YQLQueryUtil yqlUitl)
    {
        super(yqlUitl);
    }

    public DraftResults getDraftResults (String leagueid)
    {

        Map<String,Object> userData;
        List<Map<String, Object>> draftList;
        Map<String,Object> query;
        DraftResults  leagueListResults = new DraftResults();
        String yql = "select * from fantasysports.draftresults where league_key='"+leagueid+"'";

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> results = performYQLQuery(yql); //result details
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
