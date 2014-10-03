/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.utils.yql;


import com.simpleyql.Api;
import com.simpleyql.ApiFactory;
import com.simpleyql.QueryResult;
import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.utils.oauth.OAuthConnection;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */

public class YQLQueryUtil 
{
    private OAuthConnection conn;
    private YahooApiInfo info;

    private static final String AUTHDATA_SEPARATOR = "&";

    public YQLQueryUtil(OAuthConnection conn, YahooApiInfo info) {
        this.conn = conn;
        this.info = info;
    }



    
    public String queryYQL (String query)
    {
         Api api = ApiFactory.getApiInstance(info.getApiKey(), info.getApiSecret(), null,true, null);
         
         
        try 
        { 
            if(conn.isAuthorized())
            {
                Logger.getLogger(YQLQueryUtil.class.getName()).log(Level.SEVERE, query);
                String authdata = conn.getAccessToken().getToken() + AUTHDATA_SEPARATOR+ conn. getAccessToken().getSecret() + AUTHDATA_SEPARATOR + conn.getOauthSessionHandle();
                QueryResult qr = api.query(query, authdata);
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
