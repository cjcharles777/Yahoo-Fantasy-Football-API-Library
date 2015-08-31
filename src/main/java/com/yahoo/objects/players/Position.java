/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;


import java.io.Serializable;

/**
 *
 * @author cedric
 */

public class Position implements Serializable
{
    private String position;
    private Integer id;
    
    
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}
