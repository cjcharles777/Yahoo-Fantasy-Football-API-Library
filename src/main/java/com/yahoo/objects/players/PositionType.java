/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.players;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author cedric
 */
@Entity
@Table(name = "PositionTypes")
public class PositionType implements Serializable
{
    
    private String position_type;
    

    @Id
    @Column(name = "positiontype", length=5, nullable=false)
    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }
    
}
