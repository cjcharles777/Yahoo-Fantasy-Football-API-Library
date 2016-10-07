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
    private String division_id;
    private String is_owned_by_current_login;
    private TeamLogo  team_logos;
    private String waiver_priority;
    private String number_of_moves;
    private String faab_balance;
    private String number_of_trades;
    private String clinched_playoffs;
    private RosterAdds roster_adds;
    private Managers managers;
    private List<Player> teamPlayers;
    private TeamStandings team_standings;
    private TeamPoints team_points;
    private TeamPoints team_projected_points;
    private String league_scoring_type;
    private String  team_paid;
    private String has_draft_grade;
    private String draft_grade;
    private String draft_recap_url;
    private String draft_position;

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
        return team_standings;
    }

    public void setStandings(TeamStandings standings) {
        this.team_standings = standings;
    }

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }


    public String getFaab_balance() {
        return faab_balance;
    }

    public void setFaab_balance(String faab_balance) {
        this.faab_balance = faab_balance;
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

    public String getLeague_scoring_type() {
        return league_scoring_type;
    }

    public void setLeague_scoring_type(String league_scoring_type) {
        this.league_scoring_type = league_scoring_type;
    }

    public TeamPoints getTeam_points() {
        return team_points;
    }

    public void setTeam_points(TeamPoints team_points) {
        this.team_points = team_points;
    }

    public TeamStandings getTeam_standings() {
        return team_standings;
    }

    public void setTeam_standings(TeamStandings team_standings) {
        this.team_standings = team_standings;
    }

    public TeamPoints getTeam_projected_points() {
        return team_projected_points;
    }

    public void setTeam_projected_points(TeamPoints team_projected_points) {
        this.team_projected_points = team_projected_points;
    }

    public String getTeam_paid() {
        return team_paid;
    }

    public void setTeam_paid(String team_paid) {
        this.team_paid = team_paid;
    }

    public String getHas_draft_grade() {
        return has_draft_grade;
    }

    public void setHas_draft_grade(String has_draft_grade) {
        this.has_draft_grade = has_draft_grade;
    }

    public String getDraft_grade() {
        return draft_grade;
    }

    public void setDraft_grade(String draft_grade) {
        this.draft_grade = draft_grade;
    }

    public String getDraft_recap_url() {
        return draft_recap_url;
    }

    public void setDraft_recap_url(String draft_recap_url) {
        this.draft_recap_url = draft_recap_url;
    }

    public String getDraft_position() {
        return draft_position;
    }

    public void setDraft_position(String draft_position) {
        this.draft_position = draft_position;
    }
}
