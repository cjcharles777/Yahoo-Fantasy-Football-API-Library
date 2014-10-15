package com.yahoo.objects.league.transactions;

import com.yahoo.objects.players.Player;

/**
 * Created by cedric on 10/15/14.
 */
public class TransactionPlayer extends Player
{
    private TransactionData transaction_data;

    public TransactionData getTransaction_data() {
        return transaction_data;
    }

    public void setTransaction_data(TransactionData transaction_data) {
        this.transaction_data = transaction_data;
    }
}
