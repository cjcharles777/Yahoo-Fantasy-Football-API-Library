/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author cedric
 */

@Entity
@Table(name = "Position")
public class Position implements Serializable
{
    private String position;
    private int id;
    
    
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "position_id", nullable=false)
    public int getId() 
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "position", length=500, nullable=false, unique=false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}
