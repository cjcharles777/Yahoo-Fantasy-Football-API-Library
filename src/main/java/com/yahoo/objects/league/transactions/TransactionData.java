package com.yahoo.objects.league.transactions;

/**
 * Created by cedric on 10/15/14.
 */
public class TransactionData
{
    private String type;
    private String source_type;
    private String destination_type;
    private String destination_team_key;
    private String destination_team_name;
    private String source_team_key;
    private String source_team_name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getDestination_type() {
        return destination_type;
    }

    public void setDestination_type(String destination_type) {
        this.destination_type = destination_type;
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
}
