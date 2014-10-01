/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * @author cedric
 */
@Entity
@Table(name = "PlayersName")
public class Name 
{
    private int id;
    private String full;
    private String first;
    private String last;
    private String ascii_first;
    private String ascii_last;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "player_name_id", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "full_name", length=1000, nullable=false)
    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
    
    @Column(name = "first_name", length=500, nullable=true)
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Column(name = "last_name", length=500, nullable=true)
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    @Column(name = "ascii_first_name", length=500, nullable=true)
    public String getAscii_first() {
        return ascii_first;
    }

    public void setAscii_first(String ascii_first) {
        this.ascii_first = ascii_first;
    }

     @Column(name = "ascii_last_name", length=500, nullable=true)
    public String getAscii_last() {
        return ascii_last;
    }

    public void setAscii_last(String ascii_last) {
        this.ascii_last = ascii_last;
    }
    
    
    
}
