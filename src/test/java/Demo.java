import com.yahoo.objects.api.YahooApiInfo;
import com.yahoo.objects.league.*;
import com.yahoo.objects.league.transactions.LeagueTransaction;
import com.yahoo.objects.league.transactions.TransactionPlayersList;
import com.yahoo.objects.players.Player;
import com.yahoo.objects.stats.SeasonStat;
import com.yahoo.objects.stats.Stat;
import com.yahoo.objects.stats.StatsList;
import com.yahoo.objects.team.*;
import com.yahoo.services.LeagueService;
import com.yahoo.services.PlayerService;
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
                TeamService teamService = new TeamService(yqlQueryUtil);
                PlayerService playerService = new PlayerService(yqlQueryUtil);

                List<League> leagues = gameService.getUserLeagues("nfl");
                for(League league : leagues)
                {
                    System.out.println(league.toString());
                }
                League testLeauge = leagues.get(0);

                List<Team> teamList = teamService.getLeagueTeams(testLeauge.getLeague_key());
                Map<String, TeamStandings> standingsMap = gameService.getLeagueStandings(testLeauge.getLeague_key());
                LeagueSettings demoLeagueSettings = gameService.getLeagueSettings(testLeauge.getLeague_key());

                for(Team team : teamList)
                {
                    TeamStandings standings = standingsMap.get(team.getTeam_key());
                    System.out.println(team.getName() + "\t Rank:" + standings.getRank());
                }

                Team demoTeam = teamList.get(0);

                Roster demoRoster = teamService.getTeamRoster(demoTeam.getTeam_key());
                WeekRosterPlayers demoRosterPlayers = demoRoster.getPlayers();
                List<Player> demoRosterPlayersList = demoRosterPlayers.getPlayer();
                System.out.println("Roster of "+ demoTeam.getName());
                for (Player p : demoRosterPlayersList)
                {
                    System.out.println(p.getName().getFull());
                    SeasonStat demoSeasonStats = playerService.getPlayerSeasonStats(p.getPlayer_key(), testLeauge.getLeague_key());
                    System.out.println("Stats for "+ p.getName().getFull());
                    StatsList demoSeasonStatList = demoSeasonStats.getStats();
                    LeagueStatCategories demoStatsCategories = demoLeagueSettings.getStat_categories();
                    Map<String, StatCategory> demoStatCategoryMap = demoStatsCategories.getStats().getStatCategoryMap();
                    for (Stat s : demoSeasonStatList.getStat())
                    {
                        StatCategory category = demoStatCategoryMap.get(s.getStat_id());
                        System.out.println(category.getDisplay_name() +" (StatID "+s.getStat_id() +") : "+ s.getValue());
                    }
                    System.out.println();
                }
                List<TeamStat> teamStats = teamService.getWeeklyTeamPointsForSeason(demoTeam.getTeam_key());
                System.out.println("Team weekly points are:");
                for(TeamStat teamStat : teamStats)
                {
                    System.out.println("Week : " + teamStat.getTeam_points().getWeek()+" Projected pts. : "+
                            teamStat.getTeam_projected_points().getTotal()+" Actual pts. : "+
                            teamStat.getTeam_points().getTotal());
                }
                List<LeagueTransaction> transactions = gameService.getLeagueTransactions(testLeauge.getLeague_key());
                for(LeagueTransaction transaction : transactions)
                {

                    System.out.println("Transaction "+ transaction.getTransaction_id()+ " is of " + transaction.getType()+" type that was "+ transaction.getStatus());
                    if (transaction.getPlayers() != null && transaction.getPlayers().getPlayer().size()>0)
                    {
                        System.out.println("Players Involved in Transaction");
                        TransactionPlayersList trxPlayers = transaction.getPlayers();
                        for (Player p : trxPlayers.getPlayer())
                        {
                            System.out.println(p.getName().getFull());
                        }
                    }
                }

            }
        }
        catch (Exception e)
        {
            System.out.println("Problem with getting accessing url.");
        }

    }
}
