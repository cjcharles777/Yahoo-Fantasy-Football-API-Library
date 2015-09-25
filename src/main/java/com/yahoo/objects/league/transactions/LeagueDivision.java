package com.yahoo.objects.league.transactions;

import com.yahoo.objects.league.LeagueMatchup;

import java.util.List;

/**
 * Created by patwhite on 9/24/15.
 */
public class LeagueDivision {
    public String division_id;
    public String name;

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
