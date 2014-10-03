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

public class PositionType implements Serializable
{
    
    private String position_type;
    


    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }
    
}
