package com.yahoo.objects.league.transactions;

import java.util.List;

/**
 * Created by patwhite on 9/24/15.
 */
public class LeagueDivisionList {
    public List<LeagueDivision> division;

    public List<LeagueDivision> getDivisions() {
        return division;
    }

    public void setDivisions(List<LeagueDivision> divisions) {
        this.division = divisions;
    }
}
