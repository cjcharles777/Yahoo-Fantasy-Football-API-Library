 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;

 import com.yahoo.objects.stats.ByeWeek;
 import com.yahoo.objects.stats.SeasonStat;
 import com.yahoo.objects.stats.WeeklyStat;
 import org.codehaus.jackson.annotate.JsonIgnoreProperties;
 import java.io.Serializable;
 import java.util.List;

 /**
  *
  * @author DMDD
  */
 @JsonIgnoreProperties({"eligible_positions", "selected_position", "is_editable"})
 public class Player implements Serializable
 {

     private int id;
     private String player_key;
     private String player_id;
     private Name name;
     private String editorial_player_key;
     private String editorial_team_key;
     private String editorial_team_full_name;
     private String editorial_team_abbr;
     private ByeWeek bye_weeks;
     private String uniform_number;
     private String display_position;
     private PlayerPic headshot;
     private String image_url;
     private String is_undroppable;
     private String position_type;
     private transient  List<Position> eligible_positions;
     private String has_player_notes;
     private String has_recent_player_notes;
     private String status;
     private String on_disabled_list;
     private List<SeasonStat> seasonStats;
     private List<WeeklyStat> weeklyStats;
     private String injury_note;




     public int getId()
     {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getPlayer_key() {
         return player_key;
     }

     public void setPlayer_key(String player_key) {
         this.player_key = player_key;
     }

     public String getPlayer_id() {
         return player_id;
     }

     public void setPlayer_id(String player_id) {
         this.player_id = player_id;
     }

     public Name getName() {
         return name;
     }

     public void setName(Name name) {
         this.name = name;
     }

     public String getEditorial_player_key() {
         return editorial_player_key;
     }

     public void setEditorial_player_key(String editorial_player_key) {
         this.editorial_player_key = editorial_player_key;
     }

     public String getEditorial_team_key() {
         return editorial_team_key;
     }

     public void setEditorial_team_key(String editorial_team_key) {
         this.editorial_team_key = editorial_team_key;
     }

     public String getEditorial_team_full_name() {
         return editorial_team_full_name;
     }

     public void setEditorial_team_full_name(String editorial_team_full_name) {
         this.editorial_team_full_name = editorial_team_full_name;
     }

     public String getEditorial_team_abbr() {
         return editorial_team_abbr;
     }

     public void setEditorial_team_abbr(String editorial_team_abbr) {
         this.editorial_team_abbr = editorial_team_abbr;
     }

     public ByeWeek getBye_weeks() {
         return bye_weeks;
     }

     public void setBye_weeks(ByeWeek bye_weeks) {
         this.bye_weeks = bye_weeks;
     }

     public String getUniform_number() {
         return uniform_number;
     }

     public void setUniform_number(String uniform_number) {
         this.uniform_number = uniform_number;
     }

     public String getDisplay_position() {
         return display_position;
     }

     public void setDisplay_position(String display_position) {
         this.display_position = display_position;
     }

     public PlayerPic getHeadshot() {
         return headshot;
     }

     public void setHeadshot(PlayerPic headshot) {
         this.headshot = headshot;
     }

     public String getImage_url() {
         return image_url;
     }

     public void setImage_url(String image_url) {
         this.image_url = image_url;
     }

     public String getIs_undroppable() {
         return is_undroppable;
     }

     public void setIs_undroppable(String is_undroppable) {
         this.is_undroppable = is_undroppable;
     }

     public String getPosition_type() {
         return position_type;
     }

     public void setPosition_type(String position_type) {
         this.position_type = position_type;
     }


     public List<Position> getEligible_positions() {
         return eligible_positions;
     }

     public void setEligible_positions(List<Position> eligible_positions) {
         this.eligible_positions = eligible_positions;
     }

     public String getHas_player_notes() {
         return has_player_notes;
     }

     public void setHas_player_notes(String has_player_notes) {
         this.has_player_notes = has_player_notes;
     }

     public String getHas_recent_player_notes() {
         return has_recent_player_notes;
     }

     public void setHas_recent_player_notes(String has_recent_player_notes) {
         this.has_recent_player_notes = has_recent_player_notes;
     }

     public List<SeasonStat> getSeasonStats()
     {
         return seasonStats;
     }

     public void setSeasonStats(List<SeasonStat> seasonStats)
     {
         this.seasonStats = seasonStats;
     }
     public List<WeeklyStat> getWeeklyStats()
     {
         return weeklyStats;
     }

     public void setWeeklyStats(List<WeeklyStat> weeklyStats)
     {
         this.weeklyStats = weeklyStats;
     }

     public String getStatus() {
         return status;
     }

     public void setStatus(String status) {
         this.status = status;
     }

     public String getOn_disabled_list() {
         return on_disabled_list;
     }

     public void setOn_disabled_list(String on_disabled_list) {
         this.on_disabled_list = on_disabled_list;
     }

     public String getInjury_note() {
         return injury_note;
     }

     public void setInjury_note(String injury_note) {
         this.injury_note = injury_note;
     }
 }
