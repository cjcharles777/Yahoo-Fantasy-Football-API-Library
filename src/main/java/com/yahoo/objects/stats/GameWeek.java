/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */


public class GameWeek implements Serializable
{
    private String year;
    private String week;
    private String start;
    private String end;
    private Date startDate;
    private Date endDate;
    private int id;

    public String getWeek()
    {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
         Integer.parseInt(week);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStart(String startStr)
    {
        try 
        {
            this.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startStr);
        } 
        catch (ParseException ex)
        {
            this.startDate = null;
            Logger.getLogger(GameWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    public Date getEndDate() {
        return endDate;
    }

    
    public void setEnd(String endStr)
    {
        try 
        {
            this.endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endStr);
            System.out.println(this.endDate.toString());
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(GameWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    public String getYear()
   {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    
    
    
    
}
