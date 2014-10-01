/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.stats;

import com.yahoo.objects.players.PositionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cedric
 */
@Entity
@Table(name = "StatCategories")
public class StatCategory implements Serializable
{
    private int stat_id;
    private String name;
    private String display_name;
    private String sort_order;
    private List<PositionType> position_types;

    @Id
    @Column(name = "statid", length=5, nullable=false)
    public int getStat_id() {
        return stat_id;
    }

    public void setStat_id(int stat_id) {
        this.stat_id = stat_id;
    }
    
    @Column(name = "name", length=100, nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "displayname", length=100, nullable=false)
    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Column(name = "sortorder", length=100, nullable=false)
    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }
    
    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(
            name="StatCategoriesPosition",
            joinColumns = @JoinColumn( name="statid"),
            inverseJoinColumns = @JoinColumn( name="positiontype")
    )
    public List<PositionType> getPosition_types() {
        return position_types;
    }

    public void setPosition_types(List<PositionType> position_types) {
        this.position_types = position_types;
    }

    @Override
    public String toString()
    {
        return display_name;
    }

}
