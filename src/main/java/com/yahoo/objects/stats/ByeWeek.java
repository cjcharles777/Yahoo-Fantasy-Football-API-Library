/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;


import java.io.Serializable;

/**
 *
 * @author cedric
 */

public class ByeWeek implements Serializable
{
    private int id;
    private String week;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
    
    
}
