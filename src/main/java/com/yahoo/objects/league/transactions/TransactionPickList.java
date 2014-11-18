package com.yahoo.objects.league.transactions;

import java.util.List;

/**
 * Created by cedric on 11/18/14.
 */
public class TransactionPickList
{
    private List<TransactionPick> pick;

    public List<TransactionPick> getPick() {
        return pick;
    }

    public void setPick(List<TransactionPick> pick) {
        this.pick = pick;
    }
}
