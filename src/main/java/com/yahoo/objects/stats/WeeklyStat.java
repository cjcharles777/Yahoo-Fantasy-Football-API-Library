/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;


import java.util.List;

/**
 *
 * @author cedric
 */

public class WeeklyStat 
{
   private int id;
    private String week;
    private String season;
    List<Stat> stats;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getWeek()
    {
        return week;
    }

    public void setWeek(String season) {
        this.week = season;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public WeeklyStat(String week, String season, List<Stat> stats)
    {
        super();
        this.week = week;
        this.season = season;
        this.stats = stats;
    }

    public WeeklyStat() 
    {
        super();
    }
    
    
        
}
