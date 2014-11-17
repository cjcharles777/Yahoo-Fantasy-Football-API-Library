package com.yahoo.engine;

import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.query.YQLQuery;
import com.yahoo.utils.oauth.OAuthConnection;
import com.yahoo.utils.yql.YQLQueryUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cedric on 11/17/14.
 */
public class YahooFantasyEngine
{
    private static YQLQueryUtil yqlQueryUtil;
    private static OAuthConnection oAuthConn;

    public YahooFantasyEngine(YahooApiInfo info)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-config.xml");
        oAuthConn = applicationContext.getBean(OAuthConnection.class);
        oAuthConn.initService(info);
        yqlQueryUtil = applicationContext.getBean(YQLQueryUtil.class);
        yqlQueryUtil.init(info);
    }

    public static YQLQueryUtil getYqlQueryUtil() {
        return yqlQueryUtil;
    }

    public static OAuthConnection getoAuthConn() {
        return oAuthConn;
    }
}
