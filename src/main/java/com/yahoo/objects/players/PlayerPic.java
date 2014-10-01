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
@Table(name = "PlayerPic")
public class PlayerPic implements Serializable
{
    
    private int id;
    private String url;
    private String size;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "player_pic_id", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "url",length=1000, nullable=false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    @Column(name = "pic_size",length=1000, nullable=false)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
    
}
