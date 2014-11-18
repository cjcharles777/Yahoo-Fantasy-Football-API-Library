package com.yahoo.services;

import com.yahoo.objects.query.YQLQuery;
import com.yahoo.services.*;
import com.yahoo.services.enums.ServiceType;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by cedric on 11/18/14.
 */
@Component("yahooServiceFactory")
public class YahooServiceFactory
{
    @Autowired
    private  YQLQueryUtil yqlUtil;


    public BaseService getService(ServiceType serviceType)
    {
        BaseService service = null;
        switch (serviceType)
        {
            case DRAFT:
                service = new DraftService(yqlUtil);
                break;
            case GAME:
                service = new GameService(yqlUtil);
                break;
            case LEAGUE:
                service = new LeagueService(yqlUtil);
                break;
            case PLAYER:
                service = new PlayerService(yqlUtil);
                break;
            case TEAM:
                service = new TeamService(yqlUtil);
                break;
            default:
                // throw some exception
                break;
        }
        return service;
    }
}
