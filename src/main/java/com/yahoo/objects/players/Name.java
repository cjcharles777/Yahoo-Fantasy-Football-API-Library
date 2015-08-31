/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;



/**
 *
 * @author cedric
 */
public class Name
{
    private Integer id;
    private String full;
    private String first;
    private String last;
    private String ascii_first;
    private String ascii_last;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    public String getAscii_first() {
        return ascii_first;
    }

    public void setAscii_first(String ascii_first) {
        this.ascii_first = ascii_first;
    }

    public String getAscii_last() {
        return ascii_last;
    }

    public void setAscii_last(String ascii_last) {
        this.ascii_last = ascii_last;
    }
    
    
    
}
