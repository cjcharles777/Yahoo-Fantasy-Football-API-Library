package com.yahoo.objects.league.transactions;

/**
 * Created by cedric on 10/15/14.
 */
public class LeagueTransaction
{
    private String transaction_key;
    private String transaction_id;
    private String type;
    private String status;
    private String timestamp;
    private String trader_team_key;
    private String trader_team_name;
    private String tradee_team_key;
    private String tradee_team_name;
    private TransactionPlayersList players;

    public String getTransaction_key() {
        return transaction_key;
    }

    public void setTransaction_key(String transaction_key) {
        this.transaction_key = transaction_key;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionPlayersList getPlayers() {
        return players;
    }

    public void setPlayers(TransactionPlayersList players) {
        this.players = players;
    }

    public String getTrader_team_key() {
        return trader_team_key;
    }

    public void setTrader_team_key(String trader_team_key) {
        this.trader_team_key = trader_team_key;
    }

    public String getTrader_team_name() {
        return trader_team_name;
    }

    public void setTrader_team_name(String trader_team_name) {
        this.trader_team_name = trader_team_name;
    }

    public String getTradee_team_key() {
        return tradee_team_key;
    }

    public void setTradee_team_key(String tradee_team_key) {
        this.tradee_team_key = tradee_team_key;
    }

    public String getTradee_team_name() {
        return tradee_team_name;
    }

    public void setTradee_team_name(String tradee_team_name) {
        this.tradee_team_name = tradee_team_name;
    }
}
