import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.league.League;
import com.yahoo.objects.team.Team;
import com.yahoo.objects.team.TeamStandings;
import com.yahoo.services.GameService;
import com.yahoo.services.LeagueService;
import com.yahoo.services.TeamService;
import com.yahoo.utils.oauth.OAuthConnection;
import com.yahoo.utils.yql.YQLQueryUtil;

import java.util.List;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;

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

                LeagueService gameService = new LeagueService(yqlQueryUtil);
                List<League> leagues = gameService.getUserLeagues("nfl");
                for(League league : leagues)
                {
                    System.out.println(league.toString());
                }
                League testLeauge = leagues.get(0);
                TeamService teamService = new TeamService(yqlQueryUtil);
                List<Team> teamList = teamService.getLeagueTeams(testLeauge.getLeague_key());
                Map<String, TeamStandings> standingsMap = gameService.getLeagueStandings(testLeauge.getLeague_key());

                for(Team team : teamList)
                {
                    TeamStandings standings = standingsMap.get(team.getTeam_key());
                    System.out.println(team.getName() + "\t Rank:" + standings.getRank());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Problem with getting accessing url.");
        }

    }
}
