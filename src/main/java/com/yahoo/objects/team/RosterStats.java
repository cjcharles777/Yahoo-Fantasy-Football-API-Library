package com.yahoo.objects.team;

import java.math.BigDecimal;

/**
 * Created by cedric on 11/4/14.
 */
public class RosterStats
{
    private String playerKey;
    private String selectedPosition;
    private BigDecimal playerPoints;

    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }

    public String getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(String selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public BigDecimal getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(BigDecimal playerPoints) {
        this.playerPoints = playerPoints;
    }
}
