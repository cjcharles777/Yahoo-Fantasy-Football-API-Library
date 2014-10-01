/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author cedric
 */
@Entity
@Table(name = "WeeklyStat")
public class WeeklyStat 
{
   private int id;
    private String week;
    private String season;
    List<Stat> stats;

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "weekly_stat_id", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "week", length=4, nullable=false)
    public String getWeek()
    {
        return week;
    }

    public void setWeek(String season) {
        this.week = season;
    }

    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable(
            name="WeeklyStatsToStats",
            joinColumns = @JoinColumn( name="weekly_stat_id"),
            inverseJoinColumns = @JoinColumn( name="table_stat_id")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
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
