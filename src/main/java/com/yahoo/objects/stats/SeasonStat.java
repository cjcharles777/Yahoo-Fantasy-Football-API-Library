/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;


import java.util.List;

/**
 *
 * @author DMDD
 */

public class SeasonStat 
{
    private int id;
    private String season;
    private String coverage_type;
    StatsList stats;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSeason()
    {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public StatsList getStats() {
        return stats;
    }

    public void setStats(StatsList stats) {
        this.stats = stats;
    }

    public String getCoverage_type() {
        return coverage_type;
    }

    public void setCoverage_type(String coverage_type) {
        this.coverage_type = coverage_type;
    }
}
