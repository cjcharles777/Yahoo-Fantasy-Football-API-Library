/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.utils.yql;


import com.simpleyql.Api;
import com.simpleyql.ApiFactory;
import com.simpleyql.QueryResult;
import com.yahoo.dao.interfaces.YQLQueryDAO;
import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.query.YQLQuery;
import com.yahoo.utils.oauth.OAuthConnection;
import com.yahoo.utils.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */

@Repository("yqlQueryUtil")
public class YQLQueryUtil 
{
    @Autowired
    private OAuthConnection conn;
    @Autowired
    private YQLQueryDAO yqlQueryDAO;

    private Api api;



    private static final String AUTHDATA_SEPARATOR = "&";

    public YQLQueryUtil()
    {

    }

    public void init(YahooApiInfo info)
    {
        api = ApiFactory.getApiInstance(info.getApiKey(), info.getApiSecret(), null,true, null);
    }

    public String queryYQL (String query)
    {
        return queryYQL(query, 1);
    }
    
    public String queryYQL (String query, int daysTilStale)
    {

         
         
        try 
        { 
            if(conn.isAuthorized())
            {
                Logger.getLogger(YQLQueryUtil.class.getName()).log(Level.INFO, query);
                String authdata = conn.getAccessToken().getToken() + AUTHDATA_SEPARATOR+ conn. getAccessToken().getSecret() + AUTHDATA_SEPARATOR + conn.getOauthSessionHandle();
                YQLQuery attemptedQuery = new YQLQuery();
                attemptedQuery.setQuery(query);
                List<YQLQuery> results = yqlQueryDAO.retrieveQuerybyExample(attemptedQuery);
                if(results.size()>0)
                {
                    for(YQLQuery result : results)
                    {
                        if (!TimeUtil.isDataStale(result.getCreated(),daysTilStale))
                        {
                            return result.getResponse();
                        }
                        else
                        {
                            yqlQueryDAO.deleteQuery(result);
                        }
                    }

                }

                    QueryResult qr = api.query(query, authdata);
                    attemptedQuery.setResponse(qr.getText());
                    attemptedQuery.setCreated(new Date());
                    yqlQueryDAO.saveQuery(attemptedQuery);
                    return qr.getText();


            }
            else
            {
                return null;
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(YQLQueryUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public OAuthConnection getConn() {
        return conn;
    }

    public void setConn(OAuthConnection conn) {
        this.conn = conn;
    }


}
