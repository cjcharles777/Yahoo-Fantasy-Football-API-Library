/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.team;

import com.yahoo.objects.players.Player;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 *
 * @author cedric
 */
@JsonIgnoreProperties({"managers"})
public class Team 
{
    private String gameKey;
    private String leaugeid;
    private String team_key;
    private String team_id;
    private String name;
    private String url;
    private String teamLogoUrl;
    private String is_owned_by_current_login;
    private TeamLogo  team_logos;
    private String waiver_priority;
    private String number_of_moves;
    private String number_of_trades;
    private String clinched_playoffs;
    private RosterAdds roster_adds;
    private Managers managers;
    private List<Player> teamPlayers;
    private TeamStandings standings;

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String teamKey) {
        this.team_key = teamKey;
        String[] temp = StringUtils.split(teamKey, ".");
        setLeaugeid(temp[0]+"."+temp[1]+"."+temp[2]);
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamurl() {
        return url;
    }

    public void setTeamurl(String teamurl) {
        this.url = teamurl;
    }

    public String getTeamLogoUrl() {
        return teamLogoUrl;
    }

    public void setTeamLogoUrl(String teamLogoUrl) {
        this.teamLogoUrl = teamLogoUrl;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public String getLeaugeid() {
        return leaugeid;
    }

    public void setLeaugeid(String leaugeid) {
        this.leaugeid = leaugeid;
    }

    public TeamStandings getStandings() {
        return standings;
    }

    public void setStandings(TeamStandings standings) {
        this.standings = standings;
    }
    
    
    
        @Override
    public String toString()
    {
        return name;
    }

    private static class TeamLogo {
        private TeamLogoObject team_logo;

        public TeamLogoObject getTeam_logo() {
            return team_logo;
        }

        public void setTeam_logo(TeamLogoObject team_logo) {
            this.team_logo = team_logo;
        }
        
    }

    private static class TeamLogoObject 
    {
        private String size;
        private String url;

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        
    }

    private static class RosterAdds 
    {

        private String coverage_type;
        private String coverage_value;
        private String value;

        public String getCoverage_type() {
            return coverage_type;
        }

        public void setCoverage_type(String coverage_type) {
            this.coverage_type = coverage_type;
        }

        public String getCoverage_value() {
            return coverage_value;
        }

        public void setCoverage_value(String coverage_value) {
            this.coverage_value = coverage_value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        
    }

    private static class Managers {

        private List<Manager> manager;

        public List<Manager> getManager() {
            return manager;
        }

        public void setManager(List<Manager> manager) {
            this.manager = manager;
        }
        
        
    }
    private static class Manager
    {
        private String manager_id;
        private String nickname;
        private String guid;
        private String is_current_login;

        public String getManager_id() {
            return manager_id;
        }

        public void setManager_id(String manager_id) {
            this.manager_id = manager_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getIs_current_login() {
            return is_current_login;
        }

        public void setIs_current_login(String is_current_login) {
            this.is_current_login = is_current_login;
        }
        
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIs_owned_by_current_login() {
        return is_owned_by_current_login;
    }

    public void setIs_owned_by_current_login(String is_owned_by_current_login) {
        this.is_owned_by_current_login = is_owned_by_current_login;
    }

    public TeamLogo getTeam_logos() {
        return team_logos;
    }

    public void setTeam_logos(TeamLogo team_logos) {
        this.team_logos = team_logos;
    }

    public String getWaiver_priority() {
        return waiver_priority;
    }

    public void setWaiver_priority(String waiver_priority) {
        this.waiver_priority = waiver_priority;
    }

    public String getNumber_of_moves() {
        return number_of_moves;
    }

    public void setNumber_of_moves(String number_of_moves) {
        this.number_of_moves = number_of_moves;
    }

    public String getNumber_of_trades() {
        return number_of_trades;
    }

    public void setNumber_of_trades(String number_of_trades) {
        this.number_of_trades = number_of_trades;
    }

    public RosterAdds getRoster_adds() {
        return roster_adds;
    }

    public void setRoster_adds(RosterAdds roster_adds) {
        this.roster_adds = roster_adds;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }

    public String getClinched_playoffs() {
        return clinched_playoffs;
    }

    public void setClinched_playoffs(String clinched_playoffs) {
        this.clinched_playoffs = clinched_playoffs;
    }
    
}
