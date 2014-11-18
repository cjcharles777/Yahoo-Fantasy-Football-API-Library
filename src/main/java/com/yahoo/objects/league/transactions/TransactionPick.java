package com.yahoo.objects.league.transactions;

/**
 * Created by cedric on 11/18/14.
 */
public class TransactionPick
{
    private String source_team_key;
    private String source_team_name;
    private String destination_team_key;
    private String destination_team_name;
    private String original_team_key;
    private String original_team_name;
    private String round;

    public String getSource_team_key() {
        return source_team_key;
    }

    public void setSource_team_key(String source_team_key) {
        this.source_team_key = source_team_key;
    }

    public String getSource_team_name() {
        return source_team_name;
    }

    public void setSource_team_name(String source_team_name) {
        this.source_team_name = source_team_name;
    }

    public String getDestination_team_key() {
        return destination_team_key;
    }

    public void setDestination_team_key(String destination_team_key) {
        this.destination_team_key = destination_team_key;
    }

    public String getDestination_team_name() {
        return destination_team_name;
    }

    public void setDestination_team_name(String destination_team_name) {
        this.destination_team_name = destination_team_name;
    }

    public String getOriginal_team_key() {
        return original_team_key;
    }

    public void setOriginal_team_key(String original_team_key) {
        this.original_team_key = original_team_key;
    }

    public String getOriginal_team_name() {
        return original_team_name;
    }

    public void setOriginal_team_name(String original_team_name) {
        this.original_team_name = original_team_name;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
