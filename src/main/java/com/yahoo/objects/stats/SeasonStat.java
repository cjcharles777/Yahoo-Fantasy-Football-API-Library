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
    List<Stat> stats;

    

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

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
    
}
