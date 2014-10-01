/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yahoo.objects.league;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author cedric
 */
@JsonIgnoreProperties({"stat_position_types"})
public class StatCategory
{
          private String stat_id;
          private String enabled;
          private String name;
          private String display_name;
          private String sort_order;
          private String position_type;
          private String is_only_display_stat;
          private String is_excluded_from_display;
          private Object stat_position_types;

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getIs_only_display_stat() {
        return is_only_display_stat;
    }

    public void setIs_only_display_stat(String is_only_display_stat) {
        this.is_only_display_stat = is_only_display_stat;
    }

    public String getIs_excluded_from_display() {
        return is_excluded_from_display;
    }

    public void setIs_excluded_from_display(String is_excluded_from_display) {
        this.is_excluded_from_display = is_excluded_from_display;
    }
     
    
          
}
