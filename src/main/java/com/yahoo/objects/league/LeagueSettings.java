/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.league;

/**
 *
 * @author cedric
 */
public class LeagueSettings
{
      private String draft_type;
      private String is_auction_draft;
      private String scoring_type;
      private String uses_playoff;
      private String has_playoff_consolation_games;
      private String playoff_start_week;
      private String uses_playoff_reseeding;
      private String uses_lock_eliminated_teams;
      private String num_playoff_teams;
      private String num_playoff_consolation_teams;
      private String waiver_rule;
      private String uses_faab;
      private String waiver_time;
      private String trade_end_date;
      private String trade_ratify_type;
      private String trade_reject_time;
      private String player_pool;
      private String can_trade_draft_picks;
      private String max_teams;
      private String draft_time;
      private String persistent_url;
      private String uses_roster_import;
      private String roster_import_deadline;
      private String waiver_type;
      private String post_draft_players;
      private String cant_cut_list;
      private String pickem_enabled;
      private String uses_fractional_points;
      private String uses_negative_points;


      private LeagueRosterPositionList roster_positions;
      private LeagueStatCategories stat_categories;
      private LeagueStatModifier stat_modifiers;


    public String getDraft_type() {
        return draft_type;
    }

    public void setDraft_type(String draft_type) {
        this.draft_type = draft_type;
    }

    public String getIs_auction_draft() {
        return is_auction_draft;
    }

    public void setIs_auction_draft(String is_auction_draft) {
        this.is_auction_draft = is_auction_draft;
    }

    public String getScoring_type() {
        return scoring_type;
    }

    public void setScoring_type(String scoring_type) {
        this.scoring_type = scoring_type;
    }

    public String getUses_playoff() {
        return uses_playoff;
    }

    public void setUses_playoff(String uses_playoff) {
        this.uses_playoff = uses_playoff;
    }

    public String getHas_playoff_consolation_games() {
        return has_playoff_consolation_games;
    }

    public void setHas_playoff_consolation_games(String has_playoff_consolation_games) {
        this.has_playoff_consolation_games = has_playoff_consolation_games;
    }

    public String getPlayoff_start_week() {
        return playoff_start_week;
    }

    public void setPlayoff_start_week(String playoff_start_week) {
        this.playoff_start_week = playoff_start_week;
    }

    public String getUses_playoff_reseeding() {
        return uses_playoff_reseeding;
    }

    public void setUses_playoff_reseeding(String uses_playoff_reseeding) {
        this.uses_playoff_reseeding = uses_playoff_reseeding;
    }

    public String getUses_lock_eliminated_teams() {
        return uses_lock_eliminated_teams;
    }

    public void setUses_lock_eliminated_teams(String uses_lock_eliminated_teams) {
        this.uses_lock_eliminated_teams = uses_lock_eliminated_teams;
    }

    public String getNum_playoff_teams() {
        return num_playoff_teams;
    }

    public void setNum_playoff_teams(String num_playoff_teams) {
        this.num_playoff_teams = num_playoff_teams;
    }

    public String getNum_playoff_consolation_teams() {
        return num_playoff_consolation_teams;
    }

    public void setNum_playoff_consolation_teams(String num_playoff_consolation_teams) {
        this.num_playoff_consolation_teams = num_playoff_consolation_teams;
    }

    public String getWaiver_rule() {
        return waiver_rule;
    }

    public void setWaiver_rule(String waiver_rule) {
        this.waiver_rule = waiver_rule;
    }

    public String getUses_faab() {
        return uses_faab;
    }

    public void setUses_faab(String uses_faab) {
        this.uses_faab = uses_faab;
    }

    public String getWaiver_time() {
        return waiver_time;
    }

    public void setWaiver_time(String waiver_time) {
        this.waiver_time = waiver_time;
    }

    public String getTrade_end_date() {
        return trade_end_date;
    }

    public void setTrade_end_date(String trade_end_date) {
        this.trade_end_date = trade_end_date;
    }

    public String getTrade_ratify_type() {
        return trade_ratify_type;
    }

    public void setTrade_ratify_type(String trade_ratify_type) {
        this.trade_ratify_type = trade_ratify_type;
    }

    public String getTrade_reject_time() {
        return trade_reject_time;
    }

    public void setTrade_reject_time(String trade_reject_time) {
        this.trade_reject_time = trade_reject_time;
    }

    public String getPlayer_pool() {
        return player_pool;
    }

    public void setPlayer_pool(String player_pool) {
        this.player_pool = player_pool;
    }

    public String getCan_trade_draft_picks() {
        return can_trade_draft_picks;
    }

    public void setCan_trade_draft_picks(String can_trade_draft_picks) {
        this.can_trade_draft_picks = can_trade_draft_picks;
    }

    public LeagueRosterPositionList getRoster_positions() {
        return roster_positions;
    }

    public void setRoster_positions(LeagueRosterPositionList roster_positions) {
        this.roster_positions = roster_positions;
    }

    public LeagueStatCategories getStat_categories() {
        return stat_categories;
    }

    public void setStat_categories(LeagueStatCategories stat_categories) {
        this.stat_categories = stat_categories;
    }

    public LeagueStatModifier getStat_modifiers() {
        return stat_modifiers;
    }

    public void setStat_modifiers(LeagueStatModifier stat_modifiers) {
        this.stat_modifiers = stat_modifiers;
    }

    public String getMax_teams() {
        return max_teams;
    }

    public void setMax_teams(String max_teams) {
        this.max_teams = max_teams;
    }

    public String getDraft_time() {
        return draft_time;
    }

    public void setDraft_time(String draft_time) {
        this.draft_time = draft_time;
    }

    public String getPersistent_url() {
        return persistent_url;
    }

    public void setPersistent_url(String persistent_url) {
        this.persistent_url = persistent_url;
    }

    public String getUses_roster_import() {
        return uses_roster_import;
    }

    public void setUses_roster_import(String uses_roster_import) {
        this.uses_roster_import = uses_roster_import;
    }

    public String getRoster_import_deadline() {
        return roster_import_deadline;
    }

    public void setRoster_import_deadline(String roster_import_deadline) {
        this.roster_import_deadline = roster_import_deadline;
    }

    public String getWaiver_type() {
        return waiver_type;
    }

    public void setWaiver_type(String waiver_type) {
        this.waiver_type = waiver_type;
    }

    public String getPost_draft_players() {
        return post_draft_players;
    }

    public void setPost_draft_players(String post_draft_players) {
        this.post_draft_players = post_draft_players;
    }

    public String getCant_cut_list() {
        return cant_cut_list;
    }

    public void setCant_cut_list(String cant_cut_list) {
        this.cant_cut_list = cant_cut_list;
    }

    public String getPickem_enabled() {
        return pickem_enabled;
    }


    public void setPickem_enabled(String pickem_enabled) {
        this.pickem_enabled = pickem_enabled;

    }

    public String getUses_fractional_points()
    {
        return uses_fractional_points;
    }

    public void setUses_fractional_points(String uses_fractional_points) {
        this.uses_fractional_points = uses_fractional_points;
    }

    public String getUses_negative_points() {
        return uses_negative_points;
    }

    public void setUses_negative_points(String uses_negative_points) {
        this.uses_negative_points = uses_negative_points;
    }
}
