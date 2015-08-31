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

public class PlayerPic implements Serializable
{
    
    private Integer id;
    private String url;
    private String size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
    
}
