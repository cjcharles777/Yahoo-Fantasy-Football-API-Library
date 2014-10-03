/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;



/**
 *
 * @author DMDD
 */


public class Stat 
{
    private int table_stat_id;
    String stat_id;
    private Double value;

    

    public int getTable_stat_id() {
        return table_stat_id;
    }

    public void setTable_stat_id(int table_stat_id) {
        this.table_stat_id = table_stat_id;
    }

 

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
