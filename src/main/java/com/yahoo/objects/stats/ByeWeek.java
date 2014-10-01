/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author cedric
 */
@Entity
@Table(name = "ByeWeek")
public class ByeWeek implements Serializable
{
    private int id;
    private String week;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "bye_week_id", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "week", length=2, nullable=false)
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
    
    
}
