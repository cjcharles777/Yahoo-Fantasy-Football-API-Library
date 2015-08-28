package com.yahoo.services;

import com.yahoo.exceptions.BadQueryException;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cedric on 10/8/14.
 */
public class BaseService
{
    private YQLQueryUtil yqlUitl ;

    protected BaseService(YQLQueryUtil yqlUitl)
    {
        this.yqlUitl = yqlUitl;
    }


    public Map<String, Object> performYQLQuery(String query) throws BadQueryException
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> userData;
        Map<String,Object> results;
        Map<String,Object> queryMap;
        String response = yqlUitl.queryYQL(query);
        try
        {
            userData = mapper.readValue(response, Map.class);
            queryMap = (Map<String, Object>)userData.get("query"); // query details
            results = (Map<String, Object>)queryMap.get("results"); //result details
            return results;
        }
        catch (Exception e)
        {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, e);
            throw new BadQueryException();
        }



    }
    public String performYQLQueryString(String query)
    {

        String response = yqlUitl.queryYQL(query);
        return response;


    }


}
