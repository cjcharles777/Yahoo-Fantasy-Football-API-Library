package com.yahoo.objects.league.transactions;

import com.yahoo.objects.players.Player;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.LinkedList;
import java.util.List;

/**
* Created by cedric on 10/15/14.
*/
@JsonIgnoreProperties({ "player" })
public class TransactionPlayersList
{
    private String count;

    private List<TransactionPlayer> player;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<TransactionPlayer> getPlayer() {
        return player;
    }

    public void setPlayer(List<TransactionPlayer> player) {
        this.player = player;
    }

   // public void setPlayer(TransactionPlayer player)
   // {
  //      this.player = new LinkedList<TransactionPlayer>();
 //       this.player.add(player);
   // }
}
