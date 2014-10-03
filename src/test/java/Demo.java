import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.league.League;
import com.yahoo.services.GameService;
import com.yahoo.utils.oauth.OAuthConnection;
import com.yahoo.utils.yql.YQLQueryUtil;

import java.util.List;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by cedric on 10/3/14.
 */
public class Demo
{
    public static void main( String[] args )
    {
        YahooApiInfo info =
                new YahooApiInfo("dj0yJmk9MWNNeHFyMVZneFdFJmQ9WVdrOVNqVm9hSGQ2TXpZbWNHbzlNVEU0TURVM09UYzJNZy0tJnM9Y29uc3VtZXJzZWNyZXQmeD0wYQ--",
                        "9e1bb2700b79696770c9c931b182bf12260eb4e6");

        OAuthConnection oAuthConn =  new OAuthConnection(info);
        String requestUrl = oAuthConn.retrieveAuthorizationUrl();

        try
        {
            URI uri = new java.net.URI(requestUrl);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);

            System.out.println("Please type in verifier code:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String verifier =  br.readLine();
            if(oAuthConn.retrieveAccessToken(verifier))
            {
                YQLQueryUtil yqlQueryUtil = new YQLQueryUtil(oAuthConn, info);

                GameService gameService = new GameService(yqlQueryUtil);
                List<League> leagues = gameService.getUserLeagues("nfl");
                for(League leauge : leagues)
                {
                    System.out.println(leauge.toString());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Problem with getting accessing url.");
        }

    }
}
